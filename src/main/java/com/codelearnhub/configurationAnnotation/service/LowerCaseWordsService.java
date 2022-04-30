package com.codelearnhub.configurationAnnotation.service;

import java.util.Arrays;
import java.util.List;

public class LowerCaseWordsService {

    private final PunctuationService punctuationService;
    private final List<String> words = Arrays.asList("code", "learn", "hub");

    public LowerCaseWordsService(PunctuationService punctuationService) {
        this.punctuationService = punctuationService;
    }

    public PunctuationService getPunctuationService() {
        return punctuationService;
    }

    public List<String> getAllWords(){
        return words;
    }
}