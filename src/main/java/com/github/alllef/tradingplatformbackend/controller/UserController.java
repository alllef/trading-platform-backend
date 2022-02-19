package com.github.alllef.tradingplatformbackend.controller;

import com.github.alllef.tradingplatformbackend.dto.user.UserGetDto;
import com.github.alllef.tradingplatformbackend.dto.user.UserLoginDto;
import com.github.alllef.tradingplatformbackend.dto.user.UserRegisterDto;
import com.github.alllef.tradingplatformbackend.entity.Advertisement;
import com.github.alllef.tradingplatformbackend.entity.Review;
import com.github.alllef.tradingplatformbackend.entity.User;
import com.github.alllef.tradingplatformbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        var optUser = userService.registerUser(userRegisterDto);
        if (optUser.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .build();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<User> loginUser(@RequestBody UserLoginDto userLoginDto) {
        var optUser = userService.loginUser(userLoginDto);
        if (optUser.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(optUser.get());
    }

    @GetMapping("/{id}")
    UserGetDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/reviews")
    List<Review> getReviews(@PathVariable Long id) {
        return userService.getReviews(id);
    }

    @GetMapping("/{id}/advertisements")
    List<Advertisement> getAdvertisements(@PathVariable Long id) {
        return userService.getAdvertisements(id);
    }

}
