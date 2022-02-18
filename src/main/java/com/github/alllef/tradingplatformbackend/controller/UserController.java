package com.github.alllef.tradingplatformbackend.controller;

import com.github.alllef.tradingplatformbackend.dto.user.UserLoginDto;
import com.github.alllef.tradingplatformbackend.dto.user.UserRegisterDto;
import com.github.alllef.tradingplatformbackend.entity.User;
import com.github.alllef.tradingplatformbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
