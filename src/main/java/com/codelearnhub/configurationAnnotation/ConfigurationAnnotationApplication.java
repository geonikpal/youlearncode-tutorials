package com.codelearnhub.configurationAnnotation;

import com.codelearnhub.configurationAnnotation.service.LowerCaseWordsService;
import com.codelearnhub.configurationAnnotation.service.UpperCaseWordsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationAnnotationApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ConfigurationAnnotationApplication.class, args);
		var lowerCaseBean = (LowerCaseWordsService) context.getBean("lowerCase");
		var upperCaseBean = (UpperCaseWordsService) context.getBean("upperCase");
		System.out.printf("Do both punctuation services point to the same object? %b",
				lowerCaseBean.getPunctuationService() == upperCaseBean.getPunctuationService()
		);
	}

}
