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
    Review createReview(@RequestBody ReviewCreateDto reviewCreateDto){
        return reviewService.createReview(reviewCreateDto);
    }

    @PutMapping
    Review updateReview(@RequestBody ReviewUpdateDto reviewUpdateDto){
        return reviewService.updateReview(reviewUpdateDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
