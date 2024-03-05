package com.soullive_b.soullive_be.domain.popularity.repository;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.popularity.entity.Popularity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PopularityRepository extends JpaRepository<Popularity, Long> {
    List<Popularity> findAllByModelOrderByScoreDesc(Model model);

    Optional<Popularity> findTopByModelOrderByScoreDesc(Model model);
}
