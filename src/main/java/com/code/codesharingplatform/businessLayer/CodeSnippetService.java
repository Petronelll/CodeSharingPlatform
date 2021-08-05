package com.code.codesharingplatform.businessLayer;

import com.code.codesharingplatform.persistenceLayer.CodeSnippetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Service
@Component
public class CodeSnippetService {

    private final CodeSnippetRepository codeSnippetRepository;

    @Autowired
    public CodeSnippetService(CodeSnippetRepository codeSnippetRepository) {
        this.codeSnippetRepository = codeSnippetRepository;
    }

    public CodeSnippet findCodeSnippetById(UUID id) {
        return codeSnippetRepository.findCodeSnippetById(id);
    }

    public void save(CodeSnippet codeSnippet) {
        codeSnippetRepository.save(codeSnippet);
    }

    public List<CodeSnippet> findTop10CodeSnippetsNotRestricted() {
        return codeSnippetRepository.findTop10ByTimeLessThanEqualAndViewsLessThanEqualOrderByDateDesc(0, 0);
    }

    public void deleteCodeSnippetById(UUID id) {
        codeSnippetRepository.deleteById(id);
    }

}