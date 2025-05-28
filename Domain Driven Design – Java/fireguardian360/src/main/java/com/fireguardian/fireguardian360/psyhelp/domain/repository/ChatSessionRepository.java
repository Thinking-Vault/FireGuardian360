package com.fireguardian.fireguardian360.psyhelp.domain.repository;

import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, Long> {
}
