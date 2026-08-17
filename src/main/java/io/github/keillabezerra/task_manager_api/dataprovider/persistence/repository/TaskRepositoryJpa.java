package io.github.keillabezerra.task_manager_api.dataprovider.persistence.repository;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepositoryJpa extends JpaRepository<TaskEntity, Long> {

    boolean existsByTitle(final String title);
    void deleteByTitle(final String title);
    Optional<TaskEntity> findByTitle(final String title);

}
