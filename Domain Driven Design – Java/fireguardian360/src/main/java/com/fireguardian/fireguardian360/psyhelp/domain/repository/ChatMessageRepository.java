package com.fireguardian.fireguardian360.psyhelp.domain.repository;

import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/**
 * Repositório para operações de persistência relacionadas à entidade {@link ChatMessage}.
 * Fornece métodos para recuperar mensagens de chat associadas a uma sessão específica,
 * ordenadas pelo horário de envio.
 *
 * <p>
 * Esta interface estende {@link JpaRepository}, fornecendo operações CRUD padrão,
 * além de métodos personalizados para consultas específicas de mensagens de chat.
 * </p>
 *
 */
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    /**
     * Recupera uma lista de mensagens de chat associadas ao ID de sessão especificado,
     * ordenadas pelo horário em que foram enviadas em ordem crescente.
     *
     * @param sessionId o ID da sessão de chat para recuperar as mensagens
     * @return uma lista de objetos {@link ChatMessage} ordenados pelo timestamp de envio (crescente)
     */
    List<ChatMessage> findBySessionIdOrderBySentAtAsc(Long sessionId);
}
