package com.soullive_b.soullive_be.domain.activity.entity;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component("모델 관련 작품활동")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
