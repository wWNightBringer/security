package com.example.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.Objects;


public class TokenUtil {

  private static final String SECRET_KEY = "qasdfr56gjnm.le3";

  public static boolean validateToken(String token, UserDetails userDetails) {
    String username = getUsername(token);
    return userDetails.getUsername().equals(username) && !isExpired(token);
  }

  public static String getUsername(String token) {
    return getUsernameFromClaims(getClaimsByToken(token));
  }

  public static String generateToken(Map<String, Object> claims, String subject) {
    return Jwts.builder()
        .addClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000000))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
  }

  public static Date expiredTime(String token) {
    return getClaimsByToken(token).getExpiration();
  }

  private static String getUsernameFromClaims(Claims claims) {
    return Objects.nonNull(claims) ? claims.getSubject() : null;
  }

  private static Claims getClaimsByToken(String token) {
    return Jwts.parser()
        .setSigningKey(SECRET_KEY)
        .parseClaimsJws(token)
        .getBody();
  }

  private static boolean isExpired(String token) {
    Date expiredDate = expiredTime(token);
    return expiredDate.before(new Date());
  }
}
