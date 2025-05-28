package com.fireguardian.fireguardian360.checklist.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class ChecklistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String label;
    private char status; // 'P' = pending, 'C' = completed
    private ZonedDateTime updatedAt = ZonedDateTime.now();

    /**
     * Retorna true se o item continua pendente.
     *
     * @return boolean indicando pendência.
     */
    public boolean isPending() {
        return this.status == 'P';
    }

    @Override
    public String toString() {
        return label + " (" + (status == 'P' ? "pendente" : "concluído") + ")";
    }
}
