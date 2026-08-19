package io.github.keillabezerra.task_manager_api.factory;

import io.github.keillabezerra.task_manager_api.application.command.CreateTaskCommand;
import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.CreateTaskRequest;

import java.time.LocalDateTime;

public final class CreateTaskFactory {

    private CreateTaskFactory() {
        throw new UnsupportedOperationException();
    }

    public static CreateTaskCommand buildCommand() {
        return new CreateTaskCommand("example title", "example description", LocalDateTime.now().plusDays(1), 1, Priority.HIGH);
    }

    public static CreateTaskCommand buildCommand(final CreateTaskRequest request) {
        return CreateTaskCommand.from(request);
    }

    public static CreateTaskRequest buildRequest() {
        return new CreateTaskRequest("example title", "example description", LocalDateTime.now().plusDays(1), 1, Priority.HIGH.name());
    }

}
