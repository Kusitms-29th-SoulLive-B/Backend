package com.soullive_b.soullive_be.domain.model.entity;

import com.soullive_b.soullive_be.domain.activity.entity.Activity;
import com.soullive_b.soullive_be.domain.advertisement.entity.Advertisement;
import com.soullive_b.soullive_be.domain.issue.entity.Issue;
import com.soullive_b.soullive_be.domain.keyword.entity.Keyword;
import com.soullive_b.soullive_be.domain.model.ModelType;
import com.soullive_b.soullive_be.domain.popularity.entity.Popularity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Comment("모델")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String agency;

    private String email;

    @Enumerated(EnumType.STRING)
    private ModelType type;

    private LocalDate debutAt;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Keyword> keywords;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Activity> activities;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Issue> issues;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Popularity> popularities;
}
