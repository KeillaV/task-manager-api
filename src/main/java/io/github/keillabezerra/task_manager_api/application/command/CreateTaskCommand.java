package io.github.keillabezerra.task_manager_api.application.command;

import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.CreateTaskRequest;
import io.github.keillabezerra.task_manager_api.application.enums.Priority;

import java.time.LocalDateTime;

public record CreateTaskCommand(String title, String description,
                                LocalDateTime deadline, long categoryId, Priority priority) {

    public static CreateTaskCommand from(final CreateTaskRequest request) {
        return new CreateTaskCommand(request.title(), request.description(),
                request.deadline(), request.categoryId(), Priority.valueOf(request.priority()));
    }

    public boolean hasCategory() {
        return this.categoryId != 0;
    }

}
