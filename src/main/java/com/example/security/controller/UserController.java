package com.example.security.controller;

import com.example.security.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @GetMapping
  public ResponseEntity<UserDto> getUsers() {
    return ResponseEntity.ok(new UserDto(1, "User", "user@Gmail.com"));
  }
}
