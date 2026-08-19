package io.github.keillabezerra.task_manager_api.application.usecase;

import io.github.keillabezerra.task_manager_api.application.domain.Task;
import io.github.keillabezerra.task_manager_api.application.exception.ResourceAlreadyExistsException;
import io.github.keillabezerra.task_manager_api.application.exception.ResourceNotFoundException;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter.CategoryRepositoryAdapterImpl;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter.TaskRepositoryAdapterImpl;
import io.github.keillabezerra.task_manager_api.factory.CategoryFactory;
import io.github.keillabezerra.task_manager_api.factory.CreateTaskFactory;
import io.github.keillabezerra.task_manager_api.factory.TaskFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {

    @InjectMocks
    private CreateTaskUseCase useCase;
    @Mock
    private TaskRepositoryAdapterImpl repository;
    @Mock
    private CategoryRepositoryAdapterImpl categoryRepository;

    @Test
    void shouldCreateTaskWithSuccess() {
        var command = CreateTaskFactory.buildCommand();
        var category = CategoryFactory.buildDomain();
        var task = TaskFactory.buildDomain(command, category);

        when(repository.existsByTitle(command.title())).thenReturn(false);
        when(categoryRepository.findById(command.categoryId())).thenReturn(Optional.of(category));
        when(repository.save(any(Task.class))).thenReturn(task);

        var result = assertDoesNotThrow(() -> useCase.execute(command));

        assertEquals(task, result);

        verify(repository).existsByTitle(command.title());
        verify(categoryRepository).findById(command.categoryId());
        verify(repository).save(any(Task.class));
    }

    @Test
    void shouldNotCreateTaskWhenItsTitleAlreadyExists() {
        var command = CreateTaskFactory.buildCommand();

        when(repository.existsByTitle(command.title())).thenReturn(true);

        var exception = assertThrows(ResourceAlreadyExistsException.class, () -> useCase.execute(command));

        assertTrue(exception.getMessage().contains("title " + command.title()));

        verify(repository).existsByTitle(command.title());
        verifyNoInteractions(categoryRepository);
        verify(repository, times(0)).save(any(Task.class));
    }

    @Test
    void shouldNotCreateTaskWithInvalidCategory() {
        var command = CreateTaskFactory.buildCommand();

        when(repository.existsByTitle(command.title())).thenReturn(false);
        when(categoryRepository.findById(command.categoryId())).thenReturn(Optional.empty());

        var exception = assertThrows(ResourceNotFoundException.class, () -> useCase.execute(command));

        assertTrue(exception.getMessage().contains("category"));

        verify(repository).existsByTitle(command.title());
        verify(categoryRepository).findById(command.categoryId());
        verify(repository, times(0)).save(any(Task.class));
    }

}
