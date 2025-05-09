package com.pard.server.hw4.user.service;

import com.pard.server.hw4.user.dto.UserDto;
import com.pard.server.hw4.user.entity.User;
import com.pard.server.hw4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .build();
        User saved = userRepository.save(user);
        return toDto(saved);
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        return new UserDto(user.getId(), user.getUsername());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }
}
