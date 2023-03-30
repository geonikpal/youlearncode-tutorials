package com.youlearncode.springBeanScopes.scopes.nonWeb.singleton;

import org.springframework.stereotype.Service;

@Service
public class ServiceForSingleton {

    private final Singleton singleton1;
    private final Singleton singleton2;

    public ServiceForSingleton(Singleton singleton1, Singleton singleton2) {
        this.singleton1 = singleton1;
        this.singleton2 = singleton2;
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
