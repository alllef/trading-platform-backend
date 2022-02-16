package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.Category;
import com.github.alllef.tradingplatformbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAdvertisementsByCategory(Category category);

    List<Advertisement> findAdvertisementsByAuthor(User author);

    List<Advertisement> findAdvertisementsByAuthor_IsVerified(Boolean isVerified);

}
