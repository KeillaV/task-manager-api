package io.github.keillabezerra.task_manager_api.application.adapter;

import io.github.keillabezerra.task_manager_api.application.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryAdapter {

    Task save(final Task task);
    boolean existsByTitle(final String title);
    void deleteByTitle(final String title);
    Optional<Task> findByTitle(final String title);
    List<Task> findAll();

}
