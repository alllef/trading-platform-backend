package com.github.alllef.tradingplatformbackend.controller;

import com.github.alllef.tradingplatformbackend.dto.user.UserLoginDto;
import com.github.alllef.tradingplatformbackend.dto.user.UserRegisterDto;
import com.github.alllef.tradingplatformbackend.entity.User;
import com.github.alllef.tradingplatformbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        var optUser = userService.registerUser(userRegisterDto);
        if (optUser.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .build();

        return ResponseEntity.ok(optUser.get());
    }

    @PostMapping("/login")
    ResponseEntity<User> loginUser(@RequestBody UserLoginDto userLoginDto) {
        var optUser = userService.loginUser(userLoginDto);
        if (optUser.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();

        return ResponseEntity.ok(optUser.get());
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
