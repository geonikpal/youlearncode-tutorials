package com.youlearncode.springBeanScopes.scopes.web.request;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class RequestScopeBean {

    @PreDestroy
    public void preDestroy(){
        System.out.println("Destroying bean: "+ this);
    }
}