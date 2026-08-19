package io.github.keillabezerra.task_manager_api.factory;

import io.github.keillabezerra.task_manager_api.application.domain.Category;
import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.CategoryEntity;

import java.time.LocalDateTime;

public final class CategoryFactory {

    public CategoryFactory() {
        throw new UnsupportedOperationException();
    }

    public static Category buildDomain() {
        return new Category(1, "example name", "example description");
    }

    public static CategoryEntity buildEntity() {
        var entity = new CategoryEntity();
        entity.setId(1);
        entity.setName("example name");
        entity.setDescription("example description");
        entity.setCreatedAt(LocalDateTime.now());

        return entity;
    }

}
