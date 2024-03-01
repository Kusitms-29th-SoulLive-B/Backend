package com.soullive_b.soullive_be.domain.modelkeyword.repository;

import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.modelkeyword.entity.ModelKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelKeywordRepository extends JpaRepository<ModelKeyword, Long> {
    List<ModelKeyword> findAllByKeyword(Keyword keyword);
}
