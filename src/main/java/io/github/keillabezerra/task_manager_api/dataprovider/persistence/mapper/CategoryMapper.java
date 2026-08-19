package io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.CategoryEntity;
import io.github.keillabezerra.task_manager_api.application.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", source = "id", conditionExpression = "java(domain.getId() != 0)")
    CategoryEntity toEntity(final Category domain);
    Category toDomain(final CategoryEntity entity);
    List<Category> toDomain(final List<CategoryEntity> entities);

}
