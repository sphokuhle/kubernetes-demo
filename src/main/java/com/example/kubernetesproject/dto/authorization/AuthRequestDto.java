package com.example.kubernetesproject.dto.authorization;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
