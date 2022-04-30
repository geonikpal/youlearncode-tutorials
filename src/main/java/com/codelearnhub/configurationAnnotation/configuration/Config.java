package com.codelearnhub.configurationAnnotation.configuration;

import com.codelearnhub.configurationAnnotation.service.LowerCaseWordsService;
import com.codelearnhub.configurationAnnotation.service.PunctuationService;
import com.codelearnhub.configurationAnnotation.service.UpperCaseWordsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(enforceUniqueMethods = false)
public class Config {

    @Bean
    public LowerCaseWordsService lowerCase(){
        return new LowerCaseWordsService(punctuationService());
    }

    @Bean
    public UpperCaseWordsService upperCase(){
        return new UpperCaseWordsService(punctuationService());
    }

    @Bean
    public UpperCaseWordsService upperCase(String dummy){
        return new UpperCaseWordsService(punctuationService());
    }

    @Bean
    public PunctuationService punctuationService(){
        return new PunctuationService();
    }
}
