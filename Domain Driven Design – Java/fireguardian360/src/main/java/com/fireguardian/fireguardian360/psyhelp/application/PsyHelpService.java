package com.fireguardian.fireguardian360.psyhelp.application;

import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import com.fireguardian.fireguardian360.psyhelp.domain.repository.ChatMessageRepository;
import com.fireguardian.fireguardian360.psyhelp.domain.repository.ChatSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsyHelpService {
    @Autowired private ChatSessionRepository sessionRepo;
    @Autowired private ChatMessageRepository messageRepo;

    public ChatSession startSession(ChatSession session) { return sessionRepo.save(session); }
    public ChatMessage sendMessage(ChatMessage msg) { return messageRepo.save(msg); }
    public List<ChatMessage> getMessages(Long sessionId) { return messageRepo.findBySessionIdOrderBySentAtAsc(sessionId); }
}
