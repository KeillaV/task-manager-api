package io.github.keillabezerra.task_manager_api.adapter.outbound.persistence.entity;

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
    private String status;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity categoryEntity;

    @Column(name = "DEADLINE")
    private LocalDateTime deadline;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "PRIORITY")
    private String priority;

    public TaskEntity() {

    }

}
