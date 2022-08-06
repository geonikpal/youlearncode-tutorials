package com.codelearnhub.springBootProfiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SimpleConfiguration {

    @Bean
    @Profile("dev")
    public String stringBean(){
        return "CLH";
    }

}
