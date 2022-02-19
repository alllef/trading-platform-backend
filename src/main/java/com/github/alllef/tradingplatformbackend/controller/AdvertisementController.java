package com.github.alllef.tradingplatformbackend.controller;

import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertCreateDto;
import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertGetDto;
import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertUpdateDto;
import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.PhotoAdvert;
import com.github.alllef.tradingplatformbackend.entity.Review;
import com.github.alllef.tradingplatformbackend.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {
    private final AdvertService advertService;

    @GetMapping(params = {"categoryId"})
    List<Advertisement> findAdvertsByCategory(@RequestParam Optional<Long> categoryId) {
        return advertService.findAdvertsByCategory(categoryId.get());
    }

    @GetMapping("/{id}")
    AdvertGetDto getAdvertisement(@PathVariable Long id) {
        return advertService.getAdvertisement(id);
    }

    @GetMapping("/{id}/reviews")
    List<Review> getReviews(@PathVariable Long id) {
        return advertService.getAdvertReviews(id);
    }

    @GetMapping("/{id}/photos")
    List<PhotoAdvert> getPhotos(@PathVariable Long id) {
        return advertService.getAdvertPhotos(id);
    }

    @PostMapping("/{id}/photos")
    ResponseEntity<Long> addPhoto(@RequestBody String photoLink, @PathVariable Long id) {
        return ResponseEntity.ok()
                .body(advertService.addPhoto(photoLink, id));
    }

    @DeleteMapping("/{id}/photos/{photoId}")
    ResponseEntity<?> deletePhoto(@PathVariable Long id, @PathVariable Long photoId) {
        advertService.deleteAdvertisement(id, photoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(params = {"isVerified"})
    List<Advertisement> findAdvertsByAuthorIsVerified(@RequestParam Optional<Boolean> isVerified) {
        return advertService.findAdvertsByAuthorIsVerified(isVerified.get());
    }

    @PostMapping
    ResponseEntity<Long> createAdvertisement(@RequestBody AdvertCreateDto advertCreateDto) {
        Advertisement advertisement = advertService.createAdvertisement(advertCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(advertisement.getId());
    }

    @PutMapping
    ResponseEntity<?> updateAdvertisement(@RequestBody AdvertUpdateDto advertUpdateDto) {
        advertService.updateAdvertisement(advertUpdateDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteAdvertisement(@PathVariable Long id) {
        advertService.deleteAdvertisement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
