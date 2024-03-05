package com.soullive_b.soullive_be.domain.user.entity;

import com.soullive_b.soullive_be.domain.user.EnterpriseType;
import com.soullive_b.soullive_be.domain.usermodelselect.entity.UserModelSelect;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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

    private String type;//to do: enum으로 변경

    @Enumerated(EnumType.STRING)
    private EnterpriseType enterpriseType;

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
