package com.codelearnhub.springBootProfiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
public class RetrieveProfiles {

    Environment environment;

    public RetrieveProfiles(Environment environment) {
        this.environment = environment;
        String[] defaultProfiles = environment.getDefaultProfiles();
        String[] activeProfiles = environment.getActiveProfiles();
    }

//    public RetrieveProfiles(
//            @Value("${spring.profiles.active}") String activeProfiles
//    ) {}
}
