package br.com.gestorfinanceiro.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String error,
        String message
) {
    public ApiError(HttpStatus status, String message) {
        this(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message);
    }

    public String toJson() {
        return """
                {
                    "timestamp": "%s",
                    "status": %d,
                    "error": "%s",
                    "message": "%s"
                }
                """.formatted(this.timestamp, this.status, this.error, this.message);
    }

}