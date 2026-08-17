package io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter;

import io.github.keillabezerra.task_manager_api.application.adapter.CategoryRepositoryAdapter;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper.CategoryMapper;
import io.github.keillabezerra.task_manager_api.application.domain.Category;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.repository.CategoryRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryRepositoryAdapterImpl implements CategoryRepositoryAdapter {

    private final CategoryRepositoryJpa repository;
    private final CategoryMapper mapper;

    public CategoryRepositoryAdapterImpl(CategoryRepositoryJpa repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Category save(final Category category) {
        var entity = mapper.toEntity(category);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(final long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(final long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsById(final long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Category> findAll() {
        return mapper.toDomain(repository.findAll());
    }

}
