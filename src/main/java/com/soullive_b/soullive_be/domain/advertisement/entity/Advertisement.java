package com.soullive_b.soullive_be.domain.advertisement.entity;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Comment("모델 관련 광고")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logo_url;

    private String image_url;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
