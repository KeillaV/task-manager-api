package io.github.keillabezerra.task_manager_api.application.command;

import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.factory.CreateTaskFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateTaskCommandTest {

    @Test
    void shouldHaveCategory() {
        var command = CreateTaskFactory.buildCommand();
        assertTrue(command.hasCategory());
    }

    @Test
    void shouldNotHaveCategory() {
        var command = new CreateTaskCommand("example title", "example description", LocalDateTime.now(), 0, Priority.HIGH);
        assertFalse(command.hasCategory());
    }

}
