package com.codelearnhub.autowiredinspring.controller;

import com.codelearnhub.autowiredinspring.service.LetterService;
import com.codelearnhub.autowiredinspring.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile("parameter")
public class WordParameterController {

    private final WordService wordService;
    private LetterService letterService;

    public WordParameterController(WordService wordService,
                                   @Autowired(required = false) LetterService letterService
    ) {
        this.wordService = wordService;
        this.letterService = letterService;
    }

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
