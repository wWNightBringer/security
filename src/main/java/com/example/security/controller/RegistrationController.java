package com.example.security.controller;

import com.example.security.model.dto.UserDto;
import com.example.security.model.dto.UserRegistrationDto;
import com.example.security.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
  private final RegistrationService registrationService;

  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
    UserDto user = registrationService.createUser(userRegistrationDto);
    URI location = URI.create("/registration");

    return ResponseEntity.created(location).body(user);
  }
}
