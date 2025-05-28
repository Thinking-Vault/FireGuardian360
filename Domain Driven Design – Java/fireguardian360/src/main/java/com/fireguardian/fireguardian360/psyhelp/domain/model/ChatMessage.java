package com.fireguardian.fireguardian360.psyhelp.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

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