package com.fireguardian.fireguardian360.checklist.application;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import com.fireguardian.fireguardian360.checklist.domain.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ChecklistService {
    @Autowired
    private ChecklistRepository repository;

    public ChecklistItem createItem(ChecklistItem item) {
        return repository.save(item);
    }

    public List<ChecklistItem> getItemsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public ChecklistItem updateItem(ChecklistItem item) {
        item.setUpdatedAt(ZonedDateTime.now());
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public List<ChecklistItem> getPendingItems(Long userId) {
        return repository.findByUserIdAndStatus(userId, 'P');
    }
}
