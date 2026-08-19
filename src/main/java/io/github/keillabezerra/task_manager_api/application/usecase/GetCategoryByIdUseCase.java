package io.github.keillabezerra.task_manager_api.application.usecase;

import io.github.keillabezerra.task_manager_api.application.adapter.CategoryRepositoryAdapter;
import io.github.keillabezerra.task_manager_api.application.domain.Category;
import io.github.keillabezerra.task_manager_api.application.exception.ResourceNotFoundException;

public class GetCategoryByIdUseCase {

    private final CategoryRepositoryAdapter repository;

    public GetCategoryByIdUseCase(CategoryRepositoryAdapter repository) {
        this.repository = repository;
    }

    public Category execute(final long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category"));
    }

}
