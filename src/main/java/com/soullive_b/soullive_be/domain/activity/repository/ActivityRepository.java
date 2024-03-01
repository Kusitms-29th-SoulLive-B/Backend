package com.soullive_b.soullive_be.domain.activity.repository;

import com.soullive_b.soullive_be.domain.activity.entity.Activity;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByModelOrderByDateDesc(Model model);
}
