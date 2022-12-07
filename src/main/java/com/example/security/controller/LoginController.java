package com.example.security.controller;

import com.example.security.model.dto.TokenDto;
import com.example.security.model.dto.UserLoginDto;
import com.example.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;

  @PostMapping
  public ResponseEntity<TokenDto> loginUser(@RequestBody UserLoginDto userDto) {
    TokenDto tokenDto = loginService.createToken(userDto);
    return ResponseEntity.ok(tokenDto);
  }
}
