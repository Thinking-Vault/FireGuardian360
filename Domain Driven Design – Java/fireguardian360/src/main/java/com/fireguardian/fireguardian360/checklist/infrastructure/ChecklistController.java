package com.fireguardian.fireguardian360.checklist.infrastructure;

import com.fireguardian.fireguardian360.checklist.application.ChecklistService;
import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {
    @Autowired
    private ChecklistService service;

    @PostMapping
    public ChecklistItem create(@RequestBody ChecklistItem item) {
        return service.createItem(item);
    }

    @GetMapping("/user/{userId}")
    public List<ChecklistItem> getByUser(@PathVariable Long userId) {
        return service.getItemsByUser(userId);
    }

    @PutMapping
    public ChecklistItem update(@RequestBody ChecklistItem item) {
        return service.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @GetMapping("/user/{userId}/pending")
    public List<ChecklistItem> getPending(@PathVariable Long userId) {
        return service.getPendingItems(userId);
    }
}
