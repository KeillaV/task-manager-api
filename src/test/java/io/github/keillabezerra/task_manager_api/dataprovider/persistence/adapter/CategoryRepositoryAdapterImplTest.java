package io.github.keillabezerra.task_manager_api.dataprovider.persistence.adapter;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper.CategoryMapper;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.repository.CategoryRepositoryJpa;
import io.github.keillabezerra.task_manager_api.factory.CategoryFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryRepositoryAdapterImplTest {

    private static final long CATEGORY_ID = 1;

    @InjectMocks
    private CategoryRepositoryAdapterImpl repositoryAdapter;
    @Mock
    private CategoryRepositoryJpa repository;
    @Spy
    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    @Test
    void shouldFindById() {
        var entity = CategoryFactory.buildEntity();

        when(repository.findById(CATEGORY_ID)).thenReturn(Optional.of(entity));

        var result = repositoryAdapter.findById(CATEGORY_ID).get();

        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getName(), result.getName());
        assertEquals(entity.getDescription(), result.getDescription());
        assertEquals(entity.getCreatedAt(), result.getCreatedAt());

        verify(repository).findById(CATEGORY_ID);
        verify(categoryMapper).toDomain(entity);
    }

    @Test
    void shouldNotFindById() {
        when(repository.findById(CATEGORY_ID)).thenReturn(Optional.empty());

        var result = repositoryAdapter.findById(CATEGORY_ID);

        assertTrue(result.isEmpty());

        verify(repository).findById(CATEGORY_ID);
        verifyNoInteractions(categoryMapper);
    }

}
