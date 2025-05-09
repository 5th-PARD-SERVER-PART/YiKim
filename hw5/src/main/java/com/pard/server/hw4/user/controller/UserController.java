package com.pard.server.hw4.user.controller;

import com.pard.server.hw4.user.dto.UserDto;
import com.pard.server.hw4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
