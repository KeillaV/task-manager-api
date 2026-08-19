package io.github.keillabezerra.task_manager_api.application.domain;

import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.application.enums.Status;

import java.time.LocalDateTime;

public class Task {

    private long id;
    private String title;
    private Status status;
    private String description;
    private Category category;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
    private Priority priority;

    public Task(final Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.status = builder.status;
        this.description = builder.description;
        this.category = builder.category;
        this.deadline = builder.deadline;
        this.createdAt = builder.createdAt;
        this.priority = builder.priority;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setStatus(final Status status) {
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

    public void setCreatedAt(final LocalDateTime createdAt) {
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
        var result = this.title.hashCode();
        result = 31 * result + this.description.hashCode();
        result = 31 * result + this.category.hashCode();
        result = 31 * result + this.status.hashCode();
        result = 31 * result + this.deadline.hashCode();
        result = 31 * result + this.priority.hashCode();
        return result;
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

        return this.id == otherTask.getId() &&
                this.title.equals(otherTask.getTitle()) &&
                this.description.equals(otherTask.getDescription()) &&
                this.category.equals(otherTask.getCategory()) &&
                this.status.equals(otherTask.getStatus()) &&
                this.deadline.equals(otherTask.getDeadline()) &&
                this.priority.equals(otherTask.getPriority());
    }

    @Override
    public String toString() {
        return "Title: " + this.title + "\nDescription: " + this.description +
                "\nStatus: " + status.name();
    }

    public static class Builder {
        private long id;
        private String title;
        private Status status;
        private String description;
        private Category category;
        private LocalDateTime deadline;
        private LocalDateTime createdAt;
        private Priority priority;

        public Builder() {
            this.createdAt = LocalDateTime.now();
            this.status = Status.BACKLOG;
        }

        public Builder id(final long id) {
            this.id = id;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
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
