package com.example.security.model.dto;

import java.util.Date;

public record TokenDto(String token, Date expiredTime) {
}
