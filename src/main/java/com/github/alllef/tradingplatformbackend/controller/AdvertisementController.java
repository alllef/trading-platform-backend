package com.github.alllef.tradingplatformbackend.controller;

import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertCreateDto;
import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertUpdateDto;
import com.github.alllef.tradingplatformbackend.entity.Advertisement;
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
