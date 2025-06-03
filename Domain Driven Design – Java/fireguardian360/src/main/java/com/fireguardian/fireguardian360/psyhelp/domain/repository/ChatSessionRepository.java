package com.fireguardian.fireguardian360.psyhelp.domain.repository;

import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interface de repositório para gerenciar entidades {@link ChatSession}.
 * <p>
 * Estende {@link JpaRepository} para fornecer operações CRUD padrão e métodos de consulta
 * para a entidade {@code ChatSession} com chave primária do tipo {@code Long}.
 * </p>
 */
public interface ChatSessionRepository extends JpaRepository<ChatSession, Long> {
}
