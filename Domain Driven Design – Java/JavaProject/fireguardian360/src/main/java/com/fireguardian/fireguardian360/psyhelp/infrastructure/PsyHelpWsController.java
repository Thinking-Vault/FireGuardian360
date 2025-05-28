package com.fireguardian.fireguardian360.psyhelp.infrastructure;

import com.fireguardian.fireguardian360.psyhelp.application.PsyHelpService;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PsyHelpWsController {
    @Autowired private PsyHelpService service;

    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) throws Exception {
        return service.sendMessage(message);
    }
}
