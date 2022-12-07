package com.example.security.service;

import com.example.security.model.User;
import com.example.security.model.dto.TokenDto;
import com.example.security.model.dto.UserLoginDto;
import com.example.security.repository.UserRepository;
import com.example.security.utils.ArgonUtil;
import com.example.security.utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final UserRepository userRepository;

  public TokenDto createToken(UserLoginDto userDto) {
    User user = getUserIfCorrectLoginOrPassword(userDto.username(), userDto.password());
    String token = TokenUtil.generateToken(buildClaims(user), user.getUsername());

    return new TokenDto(token, TokenUtil.expiredTime(token));
  }

  private Map<String, Object> buildClaims(User user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", user.getId());
    claims.put("email", user.getEmail());
    return claims;
  }

  private User getUserIfCorrectLoginOrPassword(String username, String password) {
    Optional<User> user =
        userRepository.findByUsername(username);

    user.ifPresent(u -> {
      boolean equals = ArgonUtil.matches(password, u.getPassword());
      if (!equals) {
        throw new AccessDeniedException("Password is incorrect");
      }
    });

    return user.orElseThrow(() -> new AccessDeniedException("Login is incorrect"));
  }
}
