package com.github.alllef.tradingplatformbackend.service;

import com.github.alllef.tradingplatformbackend.dto.review.ReviewCreateDto;
import com.github.alllef.tradingplatformbackend.dto.review.ReviewUpdateDto;
import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.Review;
import com.github.alllef.tradingplatformbackend.entity.User;
import com.github.alllef.tradingplatformbackend.repository.AdvertisementRepo;
import com.github.alllef.tradingplatformbackend.repository.ReviewRepo;
import com.github.alllef.tradingplatformbackend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;
    private final AdvertisementRepo advertisementRepo;

    public Review findReviewById(Long reviewId) {
        return reviewRepo.findById(reviewId)
                .orElseThrow();
    }

    public Review createReview(ReviewCreateDto reviewCreateDto) {
        Advertisement advertisement = advertisementRepo.findById(reviewCreateDto.getAdvertisementId())
                .orElseThrow();

        User reviewAuthor = userRepo.findById(reviewCreateDto.getReviewAuthorId())
                .orElseThrow();

        Review createdReview = Review.builder()
                .reviewAuthor(reviewAuthor)
                .advertisement(advertisement)
                .creationDate(LocalDate.now())
                .mark(reviewCreateDto.getMark())
                .content(reviewCreateDto.getContent())
                .build();

        return reviewRepo.save(createdReview);
    }

    public Review updateReview(ReviewUpdateDto reviewUpdateDto) {
        Review reviewBeforeUpdate = reviewRepo.findById(reviewUpdateDto.getReviewId())
                .orElseThrow();

        Review updatedReview = reviewBeforeUpdate.toBuilder()
                .content(reviewUpdateDto.getContent())
                .mark(reviewUpdateDto.getMark())
                .build();

        return reviewRepo.save(updatedReview);
    }

    public void deleteReview(Long reviewId){
        Review deletedReview = reviewRepo.findById(reviewId)
                .orElseThrow();

        reviewRepo.delete(deletedReview);
    }
}
