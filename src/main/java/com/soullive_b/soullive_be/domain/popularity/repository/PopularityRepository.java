package com.soullive_b.soullive_be.domain.popularity.repository;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.popularity.entity.Popularity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PopularityRepository extends JpaRepository<Popularity, Long> {
    List<Popularity> findAllByModelOrderByScoreDesc(Model model);
}
