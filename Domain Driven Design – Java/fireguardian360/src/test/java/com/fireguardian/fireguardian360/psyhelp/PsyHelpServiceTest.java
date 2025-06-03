package com.fireguardian.fireguardian360.psyhelp;


import com.fireguardian.fireguardian360.psyhelp.application.PsyHelpService;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import com.fireguardian.fireguardian360.psyhelp.domain.repository.ChatMessageRepository;
import com.fireguardian.fireguardian360.psyhelp.domain.repository.ChatSessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PsyHelpServiceTest {
    @Mock
    ChatSessionRepository sessRepo;
    @Mock
    ChatMessageRepository msgRepo;
    @InjectMocks
    PsyHelpService svc;

    @Test
    void startSessionSaves() {
        ChatSession in = new ChatSession();
        when(sessRepo.save(any())).thenAnswer(inv -> inv.getArgument(0));
        ChatSession out = svc.startSession(in);
        assertNotNull(out.getStartedAt());
    }
}