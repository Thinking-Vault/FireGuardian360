package com.fireguardian.fireguardian360.psyhelp.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;


/**
 * Representa uma sessão de chat entre um usuário e o sistema.
 * Armazena informações sobre o identificador único da sessão, usuário associado,
 * horário de início e término da sessão.
 *
 * <p>
 * Campos:
 * <ul>
 *   <li>id - Identificador único da sessão de chat.</li>
 *   <li>userId - Identificador do usuário participante da sessão.</li>
 *   <li>startedAt - Data e hora de início da sessão.</li>
 *   <li>endedAt - Data e hora de término da sessão.</li>
 * </ul>
 * </p>
 */
@Data
@Entity
public class ChatSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private ZonedDateTime startedAt = ZonedDateTime.now();
    private ZonedDateTime endedAt;
}
