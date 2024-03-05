package com.soullive_b.soullive_be.domain.issue.entity;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Comment("모델 관련 이슈")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer negative;

    private Integer positive;

    private String content;

    private String tag;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
}
