package com.youlearncode.springBeanScopes.scopes.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

@org.springframework.stereotype.Controller
public class Controller {

    private final PerWebSocketConnectionBean perWebSocketConnectionBean;

    public Controller(PerWebSocketConnectionBean perWebSocketConnectionBean) {
        this.perWebSocketConnectionBean = perWebSocketConnectionBean;
    }

    @MessageMapping("/youlearncode")
    @SendTo("/topic/messages")
    public String send(String message) {
        System.out.println(perWebSocketConnectionBean);
        return message;
    }
}
