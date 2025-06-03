package com.fireguardian.fireguardian360.psyhelp.infrastructure;

import com.fireguardian.fireguardian360.psyhelp.application.PsyHelpService;
import com.fireguardian.fireguardian360.psyhelp.domain.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Controlador WebSocket responsável por gerenciar a comunicação de mensagens de chat
 * no contexto do serviço de apoio psicológico.
 * <p>
 * Este controlador lida com mensagens recebidas dos clientes via WebSocket no destino
 * "/chat.send", delegando o processamento dessas mensagens à camada de serviço
 * {@link PsyHelpService} e transmitindo as mensagens processadas para todos os assinantes
 * do tópico "/topic/messages".
 * </p>
 *
 * <p>
 * Anotações principais:
 * <ul>
 *   <li>{@code @Controller}: Indica que esta classe é um controlador Spring.</li>
 *   <li>{@code @MessageMapping}: Mapeia métodos para destinos de mensagens WebSocket.</li>
 *   <li>{@code @SendTo}: Especifica o destino para onde a resposta será enviada.</li>
 * </ul>
 * </p>
 *
 */
@Controller
public class PsyHelpWsController {
    @Autowired private PsyHelpService service;


    /**
     * Manipula mensagens de chat recebidas no destino "/chat.send".
     * Encaminha o {@link ChatMessage} recebido para a camada de serviço para processamento,
     * e transmite o resultado para todos os assinantes do tópico "/topic/messages".
     *
     * @param message a mensagem de chat recebida do cliente
     * @return a mensagem de chat processada a ser enviada para todos os assinantes
     * @throws Exception se ocorrer um erro durante o processamento da mensagem
     */
    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) throws Exception {
        return service.sendMessage(message);
    }
}
