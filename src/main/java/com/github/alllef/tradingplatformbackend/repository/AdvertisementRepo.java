package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {

    Optional<Advertisement> findAdvertisementByCategory(Long categoryId);

    List<Advertisement> findAdvertisementsByAuthor(Long authorId);

    List<Advertisement> findAdvertisementsByAuthor_IsVerified(Boolean isVerified);

}
