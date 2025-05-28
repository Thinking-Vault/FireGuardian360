package com.fireguardian.fireguardian360.psyhelp.infrastructure;

import com.fireguardian.fireguardian360.psyhelp.application.PsyHelpService;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/psyhelp")
public class ChatController {
    @Autowired private PsyHelpService service;

    @PostMapping("/session")
    public ChatSession start(@RequestBody ChatSession session) {
        return service.startSession(session);
    }

    @GetMapping("/session/{id}/messages")
    public List<ChatMessage> messages(@PathVariable Long id) {
        return service.getMessages(id);
    }

}
