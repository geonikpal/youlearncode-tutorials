package com.codelearnhub.autowiredinspring.controller;

import com.codelearnhub.autowiredinspring.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile("setter")
public class WordSetterDIController {

    private WordService wordService;

    @Autowired
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
