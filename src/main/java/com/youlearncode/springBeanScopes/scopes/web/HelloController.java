package com.youlearncode.springBeanScopes.scopes.web;

import com.youlearncode.springBeanScopes.scopes.web.request.RequestScopeBean;
import com.youlearncode.springBeanScopes.scopes.web.session.SessionScopeBean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    private final RequestScopeBean requestScopeBean;
    private final SessionScopeBean sessionScopeBean;

    public HelloController(RequestScopeBean requestScopeBean, SessionScopeBean sessionScopeBean) {
        this.requestScopeBean = requestScopeBean;
        this.sessionScopeBean = sessionScopeBean;
    }


    @GetMapping
    public String getAll() {
        System.out.println("RequestScopeBean: "+requestScopeBean);
        System.out.println("SessionScopeBean: "+sessionScopeBean);
        return "Hello";
    }
}