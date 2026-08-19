package io.github.keillabezerra.task_manager_api.application.domain;

import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.application.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TaskTest {

    @Test
    void shouldBuildWithSuccess() {
        var title = "Example title";
        var description = "Example description";
        var status = Status.BACKLOG;

        var task = Task.builder()
                .title(title)
                .description(description)
                .status(status)
                .build();

        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(status, task.getStatus());
    }

    @Test
    void shouldBeEqualAndHaveSameHashCode() {
        var category = new Category(1, "example name", "example description");
        var deadline = LocalDateTime.now();
        var task = Task.builder().id(1).title("example title")
                .description("example description").category(category)
                .status(Status.BACKLOG).priority(Priority.HIGH).deadline(deadline).build();
        var otherTask = Task.builder().id(1).title("example title")
                .description("example description").category(category)
                .status(Status.BACKLOG).priority(Priority.HIGH).deadline(deadline).build();


        assertEquals(task, otherTask);
        assertEquals(task.hashCode(), otherTask.hashCode());
    }

    @Test
    void shouldNotBeEqualAndNotHaveSameHashCode() {
        var category = new Category(1, "example name", "example description");
        var deadline = LocalDateTime.now();
        var task = Task.builder().id(1).title("example title")
                .description("example description").category(category)
                .status(Status.BACKLOG).priority(Priority.HIGH).deadline(deadline).build();
        var otherTask = Task.builder().id(1).title("example title")
                .description("example description").category(category)
                .status(Status.BACKLOG).priority(Priority.LOW).deadline(LocalDateTime.now()).build();

        assertNotEquals(task, otherTask);
        assertNotEquals(task.hashCode(), otherTask.hashCode());
    }

}
