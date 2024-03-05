package com.soullive_b.soullive_be.domain.usermodelselect.repository;

import com.soullive_b.soullive_be.domain.model.entity.Model;
import com.soullive_b.soullive_be.domain.user.EnterpriseType;
import com.soullive_b.soullive_be.domain.user.entity.User;
import com.soullive_b.soullive_be.domain.usermodelselect.entity.UserModelSelect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserModelSelectRepository extends JpaRepository<UserModelSelect, Long> {
    List<UserModelSelect> findByEnterpriseType(EnterpriseType enterpriseType);
}
