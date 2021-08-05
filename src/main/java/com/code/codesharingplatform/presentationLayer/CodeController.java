package com.code.codesharingplatform.presentationLayer;

import com.code.codesharingplatform.businessLayer.CodeSnippet;
import com.code.codesharingplatform.businessLayer.CodeSnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class CodeController {

    CodeSnippetService codeSnippetService;

    @Autowired
    public void setCodeSnippetService(CodeSnippetService codeSnippetService) {
        this.codeSnippetService = codeSnippetService;
    }

    @GetMapping(path = "/api/code/{id}", produces = "application/json")
    @ResponseBody
    public CodeSnippet getApiCode(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        CodeSnippet codeSnippet = codeSnippetService.findCodeSnippetById(uuid);
        if (codeSnippet == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "code snippet not found"
            );
        }
        if (codeSnippet.isTimeRestricted()) {
            if (codeSnippet.getTimeLeft() <= 0) {
                codeSnippetService.deleteCodeSnippetById(uuid);
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "code snippet is no longer available"
                );
            }
        }
        if (codeSnippet.isViewsRestricted()) {
            codeSnippet.updateViews();

            // Special case when a restricted code snippet has 0 views left
            if (codeSnippet.getViews() == 0) {
                codeSnippetService.deleteCodeSnippetById(uuid);
                codeSnippet.setViews(-1);
            } else {
                codeSnippetService.save(codeSnippet);
            }
        }
        if (codeSnippet.isTimeRestricted()) {
            codeSnippet.setTime(codeSnippet.getTimeLeft());
        }

        return codeSnippet;
    }

    @GetMapping(path = "/code/{id}", produces = "text/html")
    public String getCode(@PathVariable String id, Model model) {
        model.addAttribute("codeSnippet", getApiCode(id));
        return "code";
    }

    @PostMapping(path = "/api/code/new", produces = "application/json", consumes = "application/json")
    @ResponseBody
    Map<String, String> postApiCodeNew(@RequestBody Map<String, String> requestJson) {
        String code = requestJson.get("code");
        int time = Integer.parseInt(requestJson.get("time"));
        int views = Integer.parseInt(requestJson.get("views"));

        CodeSnippet codeSnippet = new CodeSnippet();
        codeSnippet.setCode(code);
        codeSnippet.setTime(time);
        codeSnippet.setViews(views);
        codeSnippetService.save(codeSnippet);

        return Map.of(
                "id", codeSnippet.getId().toString()
        );
    }

    @GetMapping(path = "/code/new", produces = "text/html")
    public String getCodeNew() {
        return "new";
    }

    @GetMapping(path = "/api/code/latest", produces = "application/json")
    @ResponseBody
    public List<CodeSnippet> getApiCodeLatest() {
        return codeSnippetService.findTop10CodeSnippetsNotRestricted();
    }

    @GetMapping(path = "/code/latest", produces = "text/html")
    public String getCodeLatest(Model model) {
        model.addAttribute("codeSnippets", getApiCodeLatest());
        return "latest";
    }

}
