package com.youlearncode.springBeanScopes.scopes.web.session;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class SessionScopeBean {

}