package com.soullive_b.soullive_be.domain.user.repository;

import com.soullive_b.soullive_be.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findBySocialId(Long socialId);
}
