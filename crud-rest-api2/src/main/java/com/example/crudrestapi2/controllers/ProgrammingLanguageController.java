package com.example.crudrestapi2.controllers;

import com.example.crudrestapi2.entities.ProgrammingLanguage;
import com.example.crudrestapi2.repositories.ProgrammingLanguageRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProgrammingLanguageController {
    @Autowired
    ProgrammingLanguageRepositories programmingLanguageRepository;

    @GetMapping(path = "/read")
    public Page<ProgrammingLanguage> readPage(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false)Optional<Integer> size){
        if (page.isPresent() && size.isPresent()){
            PageRequest pageable = PageRequest.of(page.get(),size.get());
            Page<ProgrammingLanguage> languagePage = programmingLanguageRepository.findAll(pageable);
            return  languagePage;
        }
        else {
            Page<ProgrammingLanguage> programmingLanguagePage = Page.empty();
            return programmingLanguagePage;
        }

    }

    @PostMapping(path = "/create")
    public ProgrammingLanguage create (@RequestBody ProgrammingLanguage programmingLanguage){
        return programmingLanguageRepository.saveAndFlush(programmingLanguage);
    }
    @PatchMapping (path = "/patch/{id}")
    public ProgrammingLanguage patch (@PathVariable Long id ,@RequestBody ProgrammingLanguage programmingLanguage){
        return programmingLanguageRepository.saveAndFlush(programmingLanguage);
    }
}