package com.example.demo.login.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private Boolean success;
    private String message;
}
