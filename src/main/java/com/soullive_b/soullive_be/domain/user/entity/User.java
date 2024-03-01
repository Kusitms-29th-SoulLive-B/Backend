package com.soullive_b.soullive_be.domain.user.entity;

import com.soullive_b.soullive_be.domain.user.EnterpriseType;
import com.soullive_b.soullive_be.domain.usermodelselect.entity.UserModelSelect;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
