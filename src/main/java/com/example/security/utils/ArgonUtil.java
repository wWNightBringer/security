package com.example.security.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.nio.charset.StandardCharsets;

public class ArgonUtil {

  public static String hashPassword(String password) {
    Argon2 argon2 = Argon2Factory.create();
    return argon2.hash(2, 3000, 1, password.getBytes(StandardCharsets.UTF_8));
  }

  public static boolean matches(String rawPassword, String hashPassword) {
    Argon2 argon2 = Argon2Factory.create();
    return (argon2.verify(hashPassword, rawPassword.getBytes(StandardCharsets.UTF_8)));
  }
}
