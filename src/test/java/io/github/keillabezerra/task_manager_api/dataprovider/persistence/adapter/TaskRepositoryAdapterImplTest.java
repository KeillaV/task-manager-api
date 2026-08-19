package io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.TaskEntity;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper.CategoryMapper;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper.TaskMapper;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.repository.TaskRepositoryJpa;
import io.github.keillabezerra.task_manager_api.factory.TaskFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskRepositoryAdapterImplTest {

    private static final String TITLE = "example";

    @InjectMocks
    private TaskRepositoryAdapterImpl repositoryAdapter;
    @Mock
    private TaskRepositoryJpa repository;
    @InjectMocks
    @Spy
    private TaskMapper mapper = Mappers.getMapper(TaskMapper.class);
    @Spy
    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Test
    void shouldExistByTitle() {
        when(repository.existsByTitle(TITLE)).thenReturn(true);

        assertTrue(repositoryAdapter.existsByTitle(TITLE));

        verify(repository).existsByTitle(TITLE);
    }

    @Test
    void shouldNotExistByTitle() {
        when(repository.existsByTitle(TITLE)).thenReturn(false);

        assertFalse(repositoryAdapter.existsByTitle(TITLE));

        verify(repository).existsByTitle(TITLE);
    }

    @Test
    void shouldSave() {
        var task = TaskFactory.buildDomain();
        var entity = TaskFactory.buildEntity();

        when(repository.save(any(TaskEntity.class))).thenReturn(entity);

        var result = assertDoesNotThrow(() -> repositoryAdapter.save(task));

        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getTitle(), result.getTitle());
        assertEquals(entity.getDescription(), result.getDescription());
        assertEquals(entity.getStatus(), result.getStatus());
        assertEquals(entity.getDeadline(), result.getDeadline());
        assertEquals(entity.getCreatedAt(), result.getCreatedAt());
        assertEquals(entity.getCategory().getId(), result.getCategory().getId());
        assertEquals(entity.getCategory().getName(), result.getCategory().getName());
        assertEquals(entity.getCategory().getDescription(), result.getCategory().getDescription());

        verify(repository).save(any(TaskEntity.class));
    }

}
