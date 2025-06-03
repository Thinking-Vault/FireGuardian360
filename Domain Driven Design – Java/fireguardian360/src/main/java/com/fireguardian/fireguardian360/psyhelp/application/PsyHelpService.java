package com.fireguardian.fireguardian360.psyhelp.application;

import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import com.fireguardian.fireguardian360.psyhelp.domain.repository.ChatMessageRepository;
import com.fireguardian.fireguardian360.psyhelp.domain.repository.ChatSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Serviço responsável por gerenciar sessões de chat e mensagens no contexto de suporte psicológico.
 * 
 * <p>Fornece operações para iniciar sessões de chat, enviar mensagens e recuperar o histórico de mensagens
 * associadas a uma sessão específica. Utiliza repositórios para persistência e recuperação dos dados.</p>
 *
 * <p>Principais funcionalidades:</p>
 * <ul>
 *   <li>Iniciar uma nova sessão de chat</li>
 *   <li>Enviar e salvar mensagens de chat</li>
 *   <li>Recuperar mensagens de uma sessão, ordenadas por data de envio</li>
 * </ul>
 *
 * <p>Esta classe é anotada como {@code @Service} e deve ser gerenciada pelo Spring.</p>
 *
 */
@Service
public class PsyHelpService {
    @Autowired private ChatSessionRepository sessionRepo;
    @Autowired private ChatMessageRepository messageRepo;


    /**
     * Inicia uma nova sessão de chat salvando a instância fornecida de {@link ChatSession}.
     *
     * @param session a sessão de chat a ser iniciada e persistida
     * @return a instância de {@link ChatSession} salva
     */
    public ChatSession startSession(ChatSession session) { return sessionRepo.save(session); }


    /**
     * Envia uma mensagem de chat salvando-a no repositório de mensagens.
     *
     * @param msg o {@link ChatMessage} a ser enviado e salvo
     * @return a instância de {@link ChatMessage} salva
     */
    public ChatMessage sendMessage(ChatMessage msg) { return messageRepo.save(msg); }


    /**
     * Recupera uma lista de mensagens de chat associadas ao ID da sessão especificado,
     * ordenadas pelo horário de envio em ordem crescente.
     *
     * @param sessionId o identificador único da sessão de chat
     * @return uma lista de objetos {@link ChatMessage} para a sessão informada, ordenados pelo horário de envio
     */
    public List<ChatMessage> getMessages(Long sessionId) { return messageRepo.findBySessionIdOrderBySentAtAsc(sessionId); }
}
