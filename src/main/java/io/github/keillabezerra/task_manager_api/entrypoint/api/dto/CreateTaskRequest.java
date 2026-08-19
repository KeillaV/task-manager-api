package io.github.keillabezerra.task_manager_api.entrypoint.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Schema(description = "Request to create task")
public record CreateTaskRequest (
        @Schema(description = "Title of task", example = "Study for math class")
        @NotBlank(message = "Title can't be blank")
        @Size(min = 2, max = 50, message = "Title must have a minimum of 2 and maximum of 50 characters")
        String title,
        @Schema(description = "Description of task", example = "Study pages 1-50 from math book")
        @Size(max = 200, message = "Description must have a maximum of 200 characters")
        String description,
        @Schema(type = "string", description = "Deadline for task in date time", example = "2026-08-19 10:00")
        @Future(message = "Deadline must be in the future")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime deadline,
        long categoryId,
        @Schema(type = "string", allowableValues = {"LOW", "MEDIUM", "HIGH", "CRITICAL"})
        String priority) {
}
