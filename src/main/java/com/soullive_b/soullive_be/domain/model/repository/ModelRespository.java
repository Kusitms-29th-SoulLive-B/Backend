package com.soullive_b.soullive_be.domain.model.repository;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRespository extends JpaRepository<Model, Long> {
}
