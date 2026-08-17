package io.github.keillabezerra.task_manager_api.entrypoint.api.controller;

import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.CreateTaskRequest;
import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.ErrorResponse;
import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Task Operations")
public interface TaskController {

    @PostMapping
    @Operation(
            summary = "Create task",
            description = "Creates a task given valid data"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Task created successfully",
            content = @Content(schema = @Schema(implementation = TaskResponse.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Error creating task",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @ApiResponse(
            responseCode = "409",
            description = "Task already exists",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @ResponseStatus(HttpStatus.CREATED)
    TaskResponse create(@RequestBody @Valid final CreateTaskRequest request);

}
