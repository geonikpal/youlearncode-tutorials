package com.codelearnhub.configurationProperties.before;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

//@ConfigurationProperties("api")
//@ConstructorBinding
public record ConfigRecord(int numberOfThreads, int timeout) {}
