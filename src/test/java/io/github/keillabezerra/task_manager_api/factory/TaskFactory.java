package io.github.keillabezerra.task_manager_api.factory;

import io.github.keillabezerra.task_manager_api.application.command.CreateTaskCommand;
import io.github.keillabezerra.task_manager_api.application.domain.Category;
import io.github.keillabezerra.task_manager_api.application.domain.Task;
import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.application.enums.Status;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.TaskEntity;

import java.time.LocalDateTime;

public final class TaskFactory {

    public TaskFactory() {
        throw new UnsupportedOperationException();
    }

    public static Task buildDomain() {
        return Task.builder().id(1).title("example")
                .description("example").category(CategoryFactory.buildDomain())
                .status(Status.BACKLOG).priority(Priority.HIGH)
                .deadline(LocalDateTime.now().plusDays(1)).createdAt(LocalDateTime.now()).build();
    }

    public static Task buildDomain(final CreateTaskCommand command) {
        return Task.builder().id(1).title(command.title())
                .description(command.description()).category(CategoryFactory.buildDomain())
                .status(Status.BACKLOG).priority(command.priority())
                .deadline(command.deadline()).createdAt(LocalDateTime.now()).build();
    }

    public static Task buildDomain(final CreateTaskCommand command, final Category category) {
        return Task.builder().id(1).title(command.title())
                .description(command.description()).category(category)
                .status(Status.BACKLOG).priority(command.priority())
                .deadline(command.deadline()).createdAt(LocalDateTime.now()).build();
    }

    public static TaskEntity buildEntity() {
        var entity = new TaskEntity();
        entity.setId(1);
        entity.setTitle("example");
        entity.setCategory(CategoryFactory.buildEntity());
        entity.setDescription("example");
        entity.setStatus(Status.BACKLOG);
        entity.setPriority(Priority.HIGH);
        entity.setDeadline(LocalDateTime.now().plusDays(1));
        entity.setCreatedAt(LocalDateTime.now());

        return entity;
    }

}
