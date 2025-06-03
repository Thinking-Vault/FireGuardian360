package com.fireguardian.fireguardian360.checklist.domain.repository;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Interface de repositório para gerenciar entidades {@link ChecklistItem}.
 * <p>
 * Estende {@link JpaRepository} para fornecer operações CRUD e consultas personalizadas
 * para itens de checklist associados a usuários.
 * </p>
 *
 * <p>
 * Métodos de consulta personalizados:
 * <ul>
 *   <li>{@code findByUserId(Long userId)}: Recupera todos os itens de checklist para um usuário específico.</li>
 *   <li>{@code findByUserIdAndStatus(Long userId, char status)}: Recupera itens de checklist de um usuário filtrados por status.</li>
 * </ul>
 * </p>
 */
public interface ChecklistRepository extends JpaRepository<ChecklistItem, Long> {
    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    /**
     * Recupera uma lista de entidades {@link ChecklistItem} associadas ao ID de usuário especificado.
     *
     * @param userId o identificador único do usuário cujos itens de checklist devem ser recuperados
     * @return uma lista de objetos {@link ChecklistItem} pertencentes ao usuário especificado
     */
    List<ChecklistItem> findByUserId(Long userId);


    /**
     * Recupera uma lista de entidades {@link ChecklistItem} associadas ao ID de usuário e status especificados.
     *
     * @param userId o identificador único do usuário cujos itens de checklist devem ser recuperados
     * @param status o caractere de status para filtrar os itens do checklist (ex: 'A' para ativo, 'C' para concluído)
     * @return uma lista de objetos {@link ChecklistItem} que correspondem ao ID de usuário e status fornecidos
     */
    List<ChecklistItem> findByUserIdAndStatus(Long userId, char status);
}