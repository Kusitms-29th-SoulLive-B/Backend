package com.soullive_b.soullive_be.domain.issue.repository;

import com.soullive_b.soullive_be.domain.issue.entity.Issue;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findAllByModelOrderByDateDesc(Model model);
}
