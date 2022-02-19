package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Advertisement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdvertisementRepoTests {
    @Autowired
    AdvertisementRepo advertisementRepo;

    @Test
    void returnAdvertisementTest() {
        Advertisement advertisement = advertisementRepo.findById(1L)
                .get();
        assertEquals("Something", advertisement.getAdvertName());
    }

    @Test
    void unNestedDtoAdvertTest() {
    }
}
