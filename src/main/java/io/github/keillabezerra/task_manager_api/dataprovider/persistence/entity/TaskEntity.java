package io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity;

import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.application.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TASK")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID", nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    @Column(name = "DEADLINE")
    private LocalDateTime deadline;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "PRIORITY")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    public TaskEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setCategory(final CategoryEntity category) {
        this.category = category;
    }

    public void setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setPriority(final Priority priority) {
        this.priority = priority;
    }

}
