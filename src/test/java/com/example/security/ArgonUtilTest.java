package com.example.security;

import com.example.security.utils.ArgonUtil;
import org.junit.jupiter.api.Test;

class ArgonUtilTest {
  @Test
  public void argonTest() {
    String password = "root";
    String s = ArgonUtil.hashPassword(password);
    System.out.println(s);
  }

}