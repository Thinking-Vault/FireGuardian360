package com.fireguardian.fireguardian360.checklist.domain.repository;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChecklistRepository extends JpaRepository<ChecklistItem, Long> {
    List<ChecklistItem> findByUserId(Long userId);

    List<ChecklistItem> findByUserIdAndStatus(Long userId, char status);
}