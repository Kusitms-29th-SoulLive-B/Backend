package com.soullive_b.soullive_be.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * User테이블 정의
 */
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private Long socialId;

    private String enterprise;

    @Enumerated(EnumType.STRING)
    private EnterpriseType type;

    private String email;

    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Boolean isApproved;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserModelSelect> userModelSelects;
}
