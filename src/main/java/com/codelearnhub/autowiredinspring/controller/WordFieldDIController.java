package com.codelearnhub.autowiredinspring.controller;

import com.codelearnhub.autowiredinspring.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile("field")
public class WordFieldDIController {

    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
