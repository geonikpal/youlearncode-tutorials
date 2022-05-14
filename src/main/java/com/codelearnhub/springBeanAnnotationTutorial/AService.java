package com.codelearnhub.springBeanAnnotationTutorial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AService {

    private final SomeApiClientFromALibrary someApiClientFromALibrary;

    public AService(@Qualifier("API3") SomeApiClientFromALibrary someApiClientFromALibrary) {
        this.someApiClientFromALibrary = someApiClientFromALibrary;
    }

}