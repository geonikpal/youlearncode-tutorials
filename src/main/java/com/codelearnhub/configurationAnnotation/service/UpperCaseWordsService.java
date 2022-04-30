package com.codelearnhub.configurationAnnotation.service;

import java.util.Arrays;
import java.util.List;

public class UpperCaseWordsService {

    private final List<String> words = Arrays.asList("CODE", "LEARN", "HUB");
    private final PunctuationService punctuationService;

    public UpperCaseWordsService(PunctuationService punctuationService) {
        this.punctuationService = punctuationService;
    }

    public PunctuationService getPunctuationService() {
        return punctuationService;
    }

    public List<String> getAllWords(){
        return words;
    }
}