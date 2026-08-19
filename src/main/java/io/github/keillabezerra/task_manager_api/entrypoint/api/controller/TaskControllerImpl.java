package io.github.keillabezerra.task_manager_api.entrypoint.api.controller;

import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.CreateTaskRequest;
import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.TaskResponse;

import io.github.keillabezerra.task_manager_api.entrypoint.api.mapper.TaskResponseMapper;
import io.github.keillabezerra.task_manager_api.application.command.CreateTaskCommand;
import io.github.keillabezerra.task_manager_api.application.usecase.CreateTaskUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tasks")
public class TaskControllerImpl implements TaskController{

    private final CreateTaskUseCase createTaskUseCase;
    private final TaskResponseMapper mapper;

    public TaskControllerImpl(final CreateTaskUseCase createTaskUseCase, TaskResponseMapper mapper) {
        this.createTaskUseCase = createTaskUseCase;
        this.mapper = mapper;
    }

    @Override
    public TaskResponse create(CreateTaskRequest request) {
        var command = CreateTaskCommand.from(request);
        return mapper.toResponse(createTaskUseCase.execute(command));
    }

}
