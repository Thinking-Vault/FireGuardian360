package com.fireguardian.fireguardian360.psyhelp.domain.repository;

import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySessionIdOrderBySentAtAsc(Long sessionId);
}
