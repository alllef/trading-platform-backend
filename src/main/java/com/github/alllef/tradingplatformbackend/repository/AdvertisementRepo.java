package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepo extends JpaRepository<Advertisement,Long> {
}
