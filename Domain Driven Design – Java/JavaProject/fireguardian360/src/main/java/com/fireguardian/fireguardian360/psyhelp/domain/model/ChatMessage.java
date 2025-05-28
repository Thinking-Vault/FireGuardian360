package com.fireguardian.fireguardian360.psyhelp.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;


/**
 * Representa uma mensagem de chat trocada dentro de uma sessão.
 * Cada mensagem contém informações sobre o remetente, o conteúdo da mensagem,
 * a sessão associada e o timestamp de envio.
 *
 * <p>
 * Campos:
 * <ul>
 *   <li>id - Identificador único da mensagem de chat.</li>
 *   <li>sessionId - Identificador da sessão à qual esta mensagem pertence.</li>
 *   <li>sender - O remetente da mensagem (ex.: USER, BOT, PSY).</li>
 *   <li>text - O conteúdo da mensagem.</li>
 *   <li>sentAt - O timestamp de envio da mensagem.</li>
 * </ul>
 * </p>
 */
@Data
@Entity
public class ChatMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sessionId;
    private String sender; // USER, BOT, PSY
    @Lob private String text;
    private ZonedDateTime sentAt = ZonedDateTime.now();
}