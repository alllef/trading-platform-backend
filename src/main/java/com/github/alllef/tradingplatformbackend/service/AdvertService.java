package com.github.alllef.tradingplatformbackend.service;

import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertCreateDto;
import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertGetDto;
import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertUpdateDto;
import com.github.alllef.tradingplatformbackend.entity.*;
import com.github.alllef.tradingplatformbackend.repository.AdvertisementRepo;
import com.github.alllef.tradingplatformbackend.repository.CategoryRepo;
import com.github.alllef.tradingplatformbackend.repository.PhotoAdvertRepo;
import com.github.alllef.tradingplatformbackend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertisementRepo advertisementRepo;
    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final PhotoAdvertRepo photoAdvertRepo;

    public AdvertGetDto getAdvertisement(Long id) {
        Advertisement advertisement = advertisementRepo.findById(id)
                .orElseThrow();

        return advertisement.toGetDto();
    }

    public List<Review> getAdvertReviews(Long id) {
        Advertisement advertisement = advertisementRepo.findById(id)
                .orElseThrow();

        return advertisement.getReviews()
                .stream()
                .toList();

    }

    public List<PhotoAdvert> getAdvertPhotos(Long id) {
        Advertisement advertisement = advertisementRepo.findById(id)
                .orElseThrow();

        return advertisement.getPhotos()
                .stream()
                .toList();
    }

    public List<Advertisement> findAdvertsByCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow();

        return advertisementRepo.findAdvertisementsByCategory(category);
    }

    public Advertisement createAdvertisement(AdvertCreateDto advertCreateDto) {
        User user = userRepo.findById(advertCreateDto.getAuthorId())
                .orElseThrow();

        Category category = categoryRepo.findById(advertCreateDto.getCategoryId())
                .orElseThrow();

        Advertisement advertisement = Advertisement.builder()
                .advertName(advertCreateDto.getAdvertName())
                .author(user)
                .category(category)
                .description(advertCreateDto.getDescription())
                .price(advertCreateDto.getPrice())
                .type(advertCreateDto.getAdvertType())
                .creationDate(LocalDate.now())
                .build();

        return advertisementRepo.save(advertisement);
    }

    public Advertisement updateAdvertisement(AdvertUpdateDto advertUpdateDto) {
        Advertisement advert = advertisementRepo.findById(advertUpdateDto.getAdvertId())
                .orElseThrow();

        User author = userRepo.findById(advertUpdateDto.getAuthorId())
                .orElseThrow();

        Category category = categoryRepo.findById(advertUpdateDto.getCategoryId())
                .orElseThrow();

        Advertisement updatedAdvertisement = advert.toBuilder()
                .id(advertUpdateDto.getAdvertId())
                .author(author)
                .category(category)
                .type(advertUpdateDto.getAdvertType())
                .description(advertUpdateDto.getDescription())
                .advertName(advertUpdateDto.getAdvertName())
                .isActive(advertUpdateDto.getIsActive())
                .build();

        if (advert.getClosedByModerator() == null && advertUpdateDto.getClosedByModeratorUserId().isPresent())
            updatedAdvertisement.setCloseDate(LocalDate.now());

        return advertisementRepo.save(updatedAdvertisement);
    }

    public void deleteAdvertisement(Long advertisementId) {
        advertisementRepo.findById(advertisementId)
                .orElseThrow();

        advertisementRepo.deleteById(advertisementId);
    }

    public Long addPhoto(String photoLink, Long advertisementId) {
        Advertisement advertisement = advertisementRepo.findById(advertisementId)
                .orElseThrow();

        PhotoAdvert photoAdvert = PhotoAdvert.builder()
                .photo(photoLink)
                .advertisement(advertisement)
                .build();
        return photoAdvertRepo.save(photoAdvert)
                .getId();
    }

    public void deleteAdvertisement(Long advertisementId,Long photoId) {
        Advertisement advertisement = advertisementRepo.findById(advertisementId)
                .orElseThrow();

        PhotoAdvert photoAdvert = photoAdvertRepo.findById(photoId)
                .orElseThrow();

        photoAdvertRepo.deleteById(photoId);
    }

    public List<Advertisement> findAdvertsByAuthorIsVerified(boolean isVerified) {
        return advertisementRepo.findAdvertisementsByAuthor_IsVerified(isVerified);
    }

}
