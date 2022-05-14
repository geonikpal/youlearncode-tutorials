package com.codelearnhub.springBeanAnnotationTutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AConfig {

    //  @Bean(name = {"API1", "API2"}) it is exactly the same
    @Bean(value = {"API1", "API2"})
    public SomeApiClientFromALibrary someClassFromLibrary(){
        return new SomeApiClientFromALibrary.Builder()
                .client_id("jkod88023434")
                .client_secret("*****")
                .timeout(5000)
                .build();
    }

    @Bean(value = {"API3", "API4"}, initMethod = "connectToAPI", destroyMethod = "closeAPIConnection")
    public SomeApiClientFromALibrary someClassFromLibrary1(){
        return new SomeApiClientFromALibrary.Builder()
                .client_id("hfgjk894353")
                .client_secret("#####")
                .build();
    }

}
