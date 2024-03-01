package com.soullive_b.soullive_be.domain.advertisement.repository;

import com.soullive_b.soullive_be.domain.advertisement.entity.Advertisement;
import com.soullive_b.soullive_be.domain.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAllByModelOrderByDateDesc(Model model);
}
