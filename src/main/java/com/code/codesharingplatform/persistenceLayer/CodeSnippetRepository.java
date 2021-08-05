package com.code.codesharingplatform.persistenceLayer;

import com.code.codesharingplatform.businessLayer.CodeSnippet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CodeSnippetRepository extends CrudRepository<CodeSnippet, UUID> {
    CodeSnippet findCodeSnippetById(UUID id);
    List<CodeSnippet> findTop10ByTimeLessThanEqualAndViewsLessThanEqualOrderByDateDesc(Integer time, Integer views);
}
