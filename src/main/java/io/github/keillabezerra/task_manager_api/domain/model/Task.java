package io.github.keillabezerra.task_manager_api.domain.model;

import io.github.keillabezerra.task_manager_api.domain.model.enums.Priority;
import io.github.keillabezerra.task_manager_api.domain.model.enums.Status;

import java.time.LocalDateTime;

public class Task {

    private String title;
    private Status status;
    private String description;
    private Category category;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
    private Priority priority;

    private Task(final Builder builder) {
        this.title = builder.title;
        this.status = builder.status;
        this.description = builder.description;
        this.category = builder.category;
        this.deadline = builder.deadline;
        this.createdAt = builder.createdAt;
        this.priority = builder.priority;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Status getStatus() {
        return this.status;
    }

    public void alterStatus(final Status status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    public void setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = createdAt;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(final Priority priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        return 31 * this.title.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) object;

        return this.title.equals(otherTask.getTitle());
    }

    @Override
    public String toString() {
        return "Título: " + this.title + "\nDescrição: " + this.description +
                "\nStatus: " + status.name();
    }

    public static class Builder {
        private String title;
        private Status status;
        private String description;
        private Category category;
        private LocalDateTime deadline;
        private LocalDateTime createdAt;
        private Priority priority;

        public Builder(final String title) {
            this.title = title;
            this.createdAt = LocalDateTime.now();
            this.status = Status.BACKLOG;
        }

        public Builder status(final Status status) {
            this.status = status;
            return this;
        }

        public Builder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder category(final Category category) {
            this.category = category;
            return this;
        }

        public Builder deadline(final LocalDateTime deadline) {
            this.deadline = deadline;
            return this;
        }

        public Builder priority(final Priority priority) {
            this.priority = priority;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

}
