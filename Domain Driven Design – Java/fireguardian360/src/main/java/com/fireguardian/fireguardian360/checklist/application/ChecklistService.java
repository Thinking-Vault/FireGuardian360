package com.fireguardian.fireguardian360.checklist.application;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import com.fireguardian.fireguardian360.checklist.domain.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Classe de serviço para Checklist.
 * 
 * Serviço responsável pelo gerenciamento dos itens da checklist.
 * Fornece métodos para criar, atualizar, deletar e recuperar itens da checklist,
 * incluindo a busca por usuário e por status pendente.
 *
 * <p>
 * Métodos principais:
 * <ul>
 *   <li>{@link #createItem(ChecklistItem)} - Cria um novo item de checklist.</li>
 *   <li>{@link #getItemsByUser(Long)} - Recupera todos os itens de checklist de um usuário.</li>
 *   <li>{@link #updateItem(ChecklistItem)} - Atualiza um item de checklist existente.</li>
 *   <li>{@link #deleteItem(Long)} - Remove um item de checklist pelo ID.</li>
 *   <li>{@link #getPendingItems(Long)} - Recupera os itens pendentes de um usuário.</li>
 * </ul>
 * </p>
 *
 */
@Service
public class ChecklistService {
    @Autowired
    private ChecklistRepository repository;

    /**
     * Cria um item de checklist.
     *
     * @param item o item
     * @return o item de checklist
     */
    public ChecklistItem createItem(ChecklistItem item) {
        return repository.save(item);
    }

    /**
     * Obtém itens por usuário.
     *
     * @param userId o id do usuário
     * @return os itens do usuário
     */
    public List<ChecklistItem> getItemsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    /**
     * Atualiza um item da checklist.
     *
     * @param item o item a ser atualizado
     * @return o item de checklist atualizado
     */
    public ChecklistItem updateItem(ChecklistItem item) {
        item.setUpdatedAt(ZonedDateTime.now());
        return repository.save(item);
    }

    /**
     * Deleta um item.
     *
     * @param id o id do item
     */
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    /**
     * Obtém itens pendentes.
     *
     * @param userId o id do usuário
     * @return os itens pendentes
     */
    public List<ChecklistItem> getPendingItems(Long userId) {
        return repository.findByUserIdAndStatus(userId, 'P');
    }
}
