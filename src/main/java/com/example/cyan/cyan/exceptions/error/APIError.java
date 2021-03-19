package com.example.cyan.cyan.exceptions.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class APIError {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public APIError(HttpStatus status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public APIError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public APIError(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.debugMessage = ex.getLocalizedMessage();
    }
}
