package com.fireguardian.fireguardian360.checklist.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * A classe ChecklistItem.
 * Representa um item em uma lista de verificação associada a um usuário.
 * <p>
 * Cada ChecklistItem possui um rótulo, um status indicando se está pendente ou concluído,
 * e um timestamp para a última atualização. O status é representado por um caractere:
 * 'P' para pendente e 'C' para concluído.
 * </p>
 *
 * <p>
 * Exemplo de uso:
 * <pre>
 *     ChecklistItem item = new ChecklistItem();
 *     item.setLabel("Verificar alarme de incêndio");
 *     item.setStatus('P');
 *     boolean isPending = item.isPending(); // true se o status for 'P'
 * </pre>
 * </p>
 *
 */
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
     * Verifica se o item da checklist está atualmente pendente.
     *
     * @return {@code true} se o status do item for 'P' (pendente); {@code false} caso contrário.
     */
    public boolean isPending() {
        return this.status == 'P';
    }

    /**
     * Retorna uma representação em string do item da checklist, incluindo seu rótulo e status.
     * O status é exibido como "pendente" se for 'P', caso contrário como "concluído".
     *
     * @return uma string no formato "label (pendente|concluído)"
     */
    @Override
    public String toString() {
        return label + " (" + (status == 'P' ? "pendente" : "concluído") + ")";
    }
}
