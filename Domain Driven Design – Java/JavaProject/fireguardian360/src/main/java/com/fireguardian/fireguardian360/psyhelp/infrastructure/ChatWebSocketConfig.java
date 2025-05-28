package com.fireguardian.fireguardian360.psyhelp.infrastructure;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configuração do WebSocket para o módulo de chat da aplicação.
 * <p>
 * Esta classe habilita o suporte a WebSocket com STOMP, registrando endpoints e configurando o message broker.
 * <ul>
 *   <li>Registra o endpoint "/chat-websocket" para conexões WebSocket, permitindo requisições de qualquer origem.</li>
 *   <li>Configura um message broker simples em memória com o prefixo "/topic" para broadcast de mensagens.</li>
 *   <li>Define o prefixo "/app" para destinos de mensagens da aplicação, roteando mensagens dos clientes para métodos anotados com {@code @MessageMapping}.</li>
 * </ul>
 * <p>
 * Nota: O fallback SockJS não está habilitado nesta configuração.
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class ChatWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registra o endpoint STOMP para comunicação WebSocket.
     * <p>
     * Este método adiciona o endpoint "/chat-websocket" ao registro de endpoints STOMP,
     * permitindo que os clientes se conectem ao servidor WebSocket neste caminho. O endpoint
     * está configurado para aceitar requisições de qualquer origem, definindo allowed origins como "*".
     * Nota: O fallback SockJS não está habilitado nesta configuração.
     *
     * @param registry o {@link StompEndpointRegistry} ao qual o endpoint é adicionado
     */
    @Override
    public void registerStompEndpoints(@org.springframework.lang.NonNull StompEndpointRegistry registry) {
        // Somente endpoint STOMP, sem withSockJS()
        registry.addEndpoint("/chat-websocket")
                .setAllowedOrigins("*");
    }

    /**
     * Configura o message broker para mensagens WebSocket.
     * <p>
     * Habilita um message broker simples em memória com o prefixo de destino "/topic"
     * para broadcast de mensagens aos clientes inscritos. Define o prefixo de destino
     * da aplicação como "/app", que é usado para rotear mensagens dos clientes para métodos
     * de manipulação de mensagens (por exemplo, métodos anotados com @MessageMapping).
     *
     * @param config o {@link MessageBrokerRegistry} para configurar as opções do message broker
     */
    @Override
    public void configureMessageBroker(@org.springframework.lang.NonNull MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
}

