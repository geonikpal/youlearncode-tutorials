package com.youlearncode.springBeanScopes.scopes.nonWeb.prototype;

import org.springframework.stereotype.Service;

@Service
public class ServiceForPrototype {

    private final Prototype prototype1;
    private final Prototype prototype2;


    public ServiceForPrototype(Prototype prototype1, Prototype prototype2) {
        this.prototype1 = prototype1;
        this.prototype2 = prototype2;
        System.out.println(prototype1);
        System.out.println(prototype2);
    }
}
