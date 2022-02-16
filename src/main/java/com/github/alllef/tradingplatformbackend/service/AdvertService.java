package com.github.alllef.tradingplatformbackend.service;

import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.Category;
import com.github.alllef.tradingplatformbackend.repository.AdvertisementRepo;
import com.github.alllef.tradingplatformbackend.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertisementRepo advertisementRepo;
    private final CategoryRepo categoryRepo;

    public List<Advertisement> findAdvertsByCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow();

        return advertisementRepo.findAdvertisementsByCategory(category);
    }

    public Advertisement createAdvertisement(){

    }

    public Advertisement updateAdvertisement(){

    }

    public Advertisement deleteAdvertisement(){

    }

    public List<Advertisement> findAdvertsByAuthorIsVerified(boolean isVerified) {
        return advertisementRepo.findAdvertisementsByAuthor_IsVerified(isVerified);
    }

}
