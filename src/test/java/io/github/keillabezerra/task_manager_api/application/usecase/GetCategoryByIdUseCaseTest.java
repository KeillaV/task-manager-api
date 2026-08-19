package io.github.keillabezerra.task_manager_api.application.usecase;

import io.github.keillabezerra.task_manager_api.application.exception.ResourceNotFoundException;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter.CategoryRepositoryAdapterImpl;
import io.github.keillabezerra.task_manager_api.factory.CategoryFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCategoryByIdUseCaseTest {

    private static final long CATEGORY_ID = 1;

    @InjectMocks
    private GetCategoryByIdUseCase useCase;
    @Mock
    private CategoryRepositoryAdapterImpl repository;

    @Test
    void shouldGetCategory() {
        var category = CategoryFactory.buildDomain();

        when(repository.findById(CATEGORY_ID)).thenReturn(Optional.of(category));

        var result = assertDoesNotThrow(() -> useCase.execute(CATEGORY_ID));

        assertEquals(category, result);

        verify(repository).findById(CATEGORY_ID);
    }

    @Test
    void shouldNotGetCategory() {
        when(repository.findById(CATEGORY_ID)).thenReturn(Optional.empty());

        var exception = assertThrows(ResourceNotFoundException.class, () -> useCase.execute(CATEGORY_ID));

        assertTrue(exception.getMessage().contains("category"));

        verify(repository).findById(CATEGORY_ID);
    }
}
