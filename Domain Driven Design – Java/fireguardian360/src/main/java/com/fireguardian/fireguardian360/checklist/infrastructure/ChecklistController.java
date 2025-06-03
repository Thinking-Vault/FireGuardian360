package com.fireguardian.fireguardian360.checklist.infrastructure;

import com.fireguardian.fireguardian360.checklist.application.ChecklistService;
import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Checklist controller.
 */
/**
 * Controlador REST para gerenciamento de itens da checklist.
 * <p>
 * Fornece endpoints para criar, recuperar, atualizar e deletar itens da checklist,
 * assim como buscar itens por usuário e recuperar itens pendentes de um usuário.
 * </p>
 *
 * <ul>
 *   <li>{@code POST /checklist} - Cria um novo item da checklist.</li>
 *   <li>{@code GET /checklist/user/{userId}} - Recupera todos os itens da checklist de um usuário específico.</li>
 *   <li>{@code PUT /checklist} - Atualiza um item existente da checklist.</li>
 *   <li>{@code DELETE /checklist/{id}} - Deleta um item da checklist pelo seu ID.</li>
 *   <li>{@code GET /checklist/user/{userId}/pending} - Recupera todos os itens pendentes da checklist de um usuário específico.</li>
 * </ul>
 *
 */
@RestController
@RequestMapping("/checklist")
public class ChecklistController {
    @Autowired
    private ChecklistService service;


    /**
     * Manipula requisições HTTP POST para criar um novo item da checklist.
     *
     * @param item o {@link ChecklistItem} a ser criado, fornecido no corpo da requisição
     * @return o {@link ChecklistItem} criado
     */
    @PostMapping
    public ChecklistItem create(@RequestBody ChecklistItem item) {
        return service.createItem(item);
    }


    /**
     * Recupera uma lista de itens da checklist associados a um usuário específico.
     *
     * @param userId o ID do usuário cujos itens da checklist devem ser recuperados
     * @return uma lista de objetos {@link ChecklistItem} pertencentes ao usuário especificado
     */
    @GetMapping("/user/{userId}")
    public List<ChecklistItem> getByUser(@PathVariable Long userId) {
        return service.getItemsByUser(userId);
    }


    /**
     * Atualiza um item existente da checklist.
     *
     * @param item o objeto {@link ChecklistItem} contendo as informações atualizadas
     * @return o {@link ChecklistItem} atualizado
     */
    @PutMapping
    public ChecklistItem update(@RequestBody ChecklistItem item) {
        return service.updateItem(item);
    }


    /**
     * Deleta um item da checklist com o ID especificado.
     *
     * @param id o ID do item da checklist a ser deletado
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteItem(id);
    }


    /**
     * Recupera a lista de itens pendentes da checklist para um usuário específico.
     *
     * @param userId o ID do usuário cujos itens pendentes da checklist devem ser recuperados
     */
    @GetMapping("/user/{userId}/pending")
    public List<ChecklistItem> getPending(@PathVariable Long userId) {
        return service.getPendingItems(userId);
    }
}
