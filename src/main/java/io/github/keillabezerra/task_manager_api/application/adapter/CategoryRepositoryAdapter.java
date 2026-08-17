package io.github.keillabezerra.task_manager_api.application.adapter;

import io.github.keillabezerra.task_manager_api.application.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryAdapter {

    Category save(final Category category);
    void deleteById(final long id);
    Optional<Category> findById(final long id);
    boolean existsById(final long id);
    List<Category> findAll();

}
