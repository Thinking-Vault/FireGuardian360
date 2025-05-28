package com.fireguardian.fireguardian360.psyhelp.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@Entity
public class ChatSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private ZonedDateTime startedAt = ZonedDateTime.now();
    private ZonedDateTime endedAt;
}
