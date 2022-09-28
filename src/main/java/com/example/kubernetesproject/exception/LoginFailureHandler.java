package com.example.kubernetesproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginFailureHandler {
    private String timestamp;
    private int status;
    private String error;
    private String path;
}
