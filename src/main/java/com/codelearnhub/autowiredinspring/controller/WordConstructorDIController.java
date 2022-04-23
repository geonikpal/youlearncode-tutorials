package com.codelearnhub.autowiredinspring.controller;

import com.codelearnhub.autowiredinspring.service.WordService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile("constructor")
public class WordConstructorDIController {

    private final WordService wordService;

    // It works with or without @Autowired
    public WordConstructorDIController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
