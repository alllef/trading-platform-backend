package com.github.alllef.tradingplatformbackend.repository;

import com.github.alllef.tradingplatformbackend.entity.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class ReviewRepoTests {
    @Autowired
    ReviewRepo reviewRepo;

    @Test
    void returnReviewTest() {
       Review review = reviewRepo.findById(1L).get();
        Assertions.assertEquals("gef",review.getContent());
    }
}
