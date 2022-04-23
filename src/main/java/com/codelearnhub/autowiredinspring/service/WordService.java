package com.codelearnhub.autowiredinspring.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class WordService {

    private final List<String> words = Arrays.asList("Code", "Learn", "Hub");

    public List<String> getAllWords(){
        return words;
    }
}
