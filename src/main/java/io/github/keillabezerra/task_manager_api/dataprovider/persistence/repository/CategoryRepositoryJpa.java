package io.github.keillabezerra.task_manager_api.dataprovider.persistence.repository;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJpa extends JpaRepository<CategoryEntity, Long> {

}
