package com.smart.elearning.dto;

import com.smart.elearning.entity.AppUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private final String token;
    private final AppUser user;
}
