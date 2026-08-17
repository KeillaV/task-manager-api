package io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper.TaskMapper;
import io.github.keillabezerra.task_manager_api.application.adapter.TaskRepositoryAdapter;
import io.github.keillabezerra.task_manager_api.application.domain.Task;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.repository.TaskRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryAdapterImpl implements TaskRepositoryAdapter {

    private final TaskRepositoryJpa repository;
    private final TaskMapper mapper;

    public TaskRepositoryAdapterImpl(final TaskRepositoryJpa repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task save(final Task task) {
        var entity = mapper.toEntity(task);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public boolean existsByTitle(final String title) {
        return repository.existsByTitle(title);
    }

    @Override
    public void deleteByTitle(final String title) {
        repository.deleteByTitle(title);
    }

    @Override
    public Optional<Task> findByTitle(final String title) {
        return repository.findByTitle(title)
                .map(mapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return mapper.toDomain(repository.findAll());
    }

}
