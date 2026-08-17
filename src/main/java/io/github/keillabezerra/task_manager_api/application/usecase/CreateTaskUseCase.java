package io.github.keillabezerra.task_manager_api.application.usecase;

import io.github.keillabezerra.task_manager_api.application.adapter.CategoryRepositoryAdapter;
import io.github.keillabezerra.task_manager_api.application.command.CreateTaskCommand;
import io.github.keillabezerra.task_manager_api.application.adapter.TaskRepositoryAdapter;
import io.github.keillabezerra.task_manager_api.application.domain.Category;
import io.github.keillabezerra.task_manager_api.application.exception.ResourceAlreadyExistsException;
import io.github.keillabezerra.task_manager_api.application.domain.Task;
import io.github.keillabezerra.task_manager_api.application.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {

    private final TaskRepositoryAdapter repository;
    private final CategoryRepositoryAdapter categoryRepository;

    public CreateTaskUseCase(final TaskRepositoryAdapter repository, CategoryRepositoryAdapter categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Task execute(final CreateTaskCommand command) {
        if (repository.existsByTitle(command.title())) {
            throw new ResourceAlreadyExistsException("task", "title", command.title());
        }

        Category category = null;
        if (command.hasCategory()) {
            category = categoryRepository.findById(command.categoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("category"));
        }

        var task = Task.builder()
                .title(command.title())
                .description(command.description())
                .deadline(command.deadline())
                .priority(command.priority())
                .category(category)
                .build();

        return repository.save(task);
    }

}
