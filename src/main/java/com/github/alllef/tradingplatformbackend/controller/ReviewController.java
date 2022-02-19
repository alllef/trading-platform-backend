package com.github.alllef.tradingplatformbackend.controller;

import com.github.alllef.tradingplatformbackend.dto.review.ReviewCreateDto;
import com.github.alllef.tradingplatformbackend.dto.review.ReviewUpdateDto;
import com.github.alllef.tradingplatformbackend.entity.Review;
import com.github.alllef.tradingplatformbackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    Review findReviewById(@PathVariable Long id) {
        return reviewService.findReviewById(id);
    }

    @PostMapping
    ResponseEntity<Long> createReview(@RequestBody ReviewCreateDto reviewCreateDto) {
        Review review = reviewService.createReview(reviewCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(review.getId());
    }

    @PutMapping
    ResponseEntity<?> updateReview(@RequestBody ReviewUpdateDto reviewUpdateDto) {
        reviewService.updateReview(reviewUpdateDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
