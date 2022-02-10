package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Long, Review> {
}
