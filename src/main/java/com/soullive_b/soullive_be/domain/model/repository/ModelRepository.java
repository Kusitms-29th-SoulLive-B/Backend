package com.soullive_b.soullive_be.domain.model.repository;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findTop6ByOrderByIdAsc();
}
