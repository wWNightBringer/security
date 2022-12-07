package com.example.security.service;

import com.example.security.utils.ArgonUtil;
import com.example.security.model.User;
import com.example.security.model.dto.UserDto;
import com.example.security.model.dto.UserRegistrationDto;
import com.example.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

  private final UserRepository userRepository;

  @Transactional
  public UserDto createUser(UserRegistrationDto userRegistrationDto) {
    User save = userRepository.save(buildUser(userRegistrationDto));

    return new UserDto(save.getId(), save.getUsername(), save.getEmail());
  }

  private User buildUser(UserRegistrationDto userRegistrationDto) {
    return User.builder()
        .username(userRegistrationDto.username())
        .password(ArgonUtil.hashPassword(userRegistrationDto.password()))
        .email(userRegistrationDto.email())
        .build();
  }
}
