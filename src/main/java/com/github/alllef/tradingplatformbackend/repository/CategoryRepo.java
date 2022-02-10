package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
