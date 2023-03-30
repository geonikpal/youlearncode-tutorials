package com.youlearncode.springBeanScopes.scopes.websocket;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PerWebSocketConnectionBean {

    @PreDestroy
    public void destroy(){
        System.out.println("destroying bean: " + this);
    }
}
