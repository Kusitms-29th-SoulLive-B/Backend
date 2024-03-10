package com.soullive_b.soullive_be.domain.model.repository;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findTop6ByOrderByIdAsc();
    Optional<Model> findById(Long modelId);

    @Query("SELECT m " +
            "FROM Model m " +
            "WHERE m.name LIKE :keyword% " +
            "ORDER BY m.id " +
            "ASC")
    Page<Model> findTop5ByNameContainingKeywordOrderByIdAsc(String keyword, Pageable pageable);
}
