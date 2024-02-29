package com.soullive_b.soullive_be.domain.user.repository;


import com.soullive_b.soullive_be.domain.user.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findBySocialId(Long socialId);
}
