package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; // Added this

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor // Best practice for POJOs used in API responses
public class ErrorResponse {
    private int status;
    private String message;
    private String details;
    private LocalDateTime timestamp;
}