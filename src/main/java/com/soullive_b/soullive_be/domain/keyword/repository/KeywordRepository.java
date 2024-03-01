package com.soullive_b.soullive_be.domain.keyword.repository;

import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    List<Keyword> findTop4ByOrderByPreferenceDesc();
    Optional<Keyword> findByContent(String content);
}
