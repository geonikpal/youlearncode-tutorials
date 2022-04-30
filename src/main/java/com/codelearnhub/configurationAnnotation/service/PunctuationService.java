package com.codelearnhub.configurationAnnotation.service;

import java.util.Arrays;
import java.util.List;

public class PunctuationService {

    private final List<Character> punctuationMarks = Arrays.asList('.', ';', '!', '?');

    public List<Character> getAllPunctuationMarks(){
        return punctuationMarks;
    }

}