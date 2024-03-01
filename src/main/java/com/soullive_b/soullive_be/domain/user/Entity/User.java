package com.soullive_b.soullive_be.domain.user.Entity;

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
    private String type;
    private String email;
    private boolean is_active;
    private LocalDateTime createdAt;
    private boolean isApproved;
}
