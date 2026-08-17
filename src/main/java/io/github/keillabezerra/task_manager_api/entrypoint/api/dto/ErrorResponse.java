package io.github.keillabezerra.task_manager_api.entrypoint.api.dto;


import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private int code;
    private String message;
    private LocalDateTime timestamp;
    private List<String> errors;

    private ErrorResponse() {
    }

    public ErrorResponse(final int code, final String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(final int code, final String message, final List<String> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

}
