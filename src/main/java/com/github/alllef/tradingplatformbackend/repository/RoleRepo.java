package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Long, Role> {
}
