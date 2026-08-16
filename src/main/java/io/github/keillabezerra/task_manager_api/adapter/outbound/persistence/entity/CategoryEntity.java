package io.github.keillabezerra.task_manager_api.adapter.outbound.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "categoryEntity")
    private List<TaskEntity> taskEntities;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
