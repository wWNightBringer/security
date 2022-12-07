package com.example.security.enums;

public enum Role {
  ADMIN("admin"), USER("user"), ANONYMOUS("anonymous");

  private final String value;

  Role(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
