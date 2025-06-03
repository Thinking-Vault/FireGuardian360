package com.fireguardian.fireguardian360.psyhelp.infrastructure;

import com.fireguardian.fireguardian360.psyhelp.application.PsyHelpService;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar as operações relacionadas ao chat de apoio psicológico.
 * 
 * <p>Fornece endpoints para iniciar uma nova sessão de chat e recuperar as mensagens associadas a uma sessão específica.</p>
 *
 * <ul>
 *   <li><b>POST /psyhelp/session</b>: Inicia uma nova sessão de chat.</li>
 *   <li><b>GET /psyhelp/session/{id}/messages</b>: Recupera as mensagens de uma sessão de chat existente.</li>
 * </ul>
 *
 */
@RestController
@RequestMapping("/psyhelp")
public class ChatController {
    @Autowired private PsyHelpService service;

    /**
     * Inicia uma nova sessão de chat.
     *
     * @param session os detalhes da sessão de chat a ser iniciada
     * @return a instância iniciada de {@link ChatSession}
     */
    @PostMapping("/session")
    public ChatSession start(@RequestBody ChatSession session) {
        return service.startSession(session);
    }

    /**
     * Recupera a lista de mensagens do chat para uma sessão específica.
     *
     * @param id o identificador único da sessão de chat
     * @return uma lista de objetos {@link ChatMessage} associados à sessão
     */
    @GetMapping("/session/{id}/messages")
    public List<ChatMessage> messages(@PathVariable Long id) {
        return service.getMessages(id);
    }

}
