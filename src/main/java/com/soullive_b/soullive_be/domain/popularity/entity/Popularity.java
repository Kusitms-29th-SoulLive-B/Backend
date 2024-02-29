package com.soullive_b.soullive_be.domain.popularity.entity;


import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.popularity.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Popularity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
