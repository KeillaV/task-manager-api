package io.github.keillabezerra.task_manager_api.dataprovider.persistence.mapper;

import io.github.keillabezerra.task_manager_api.dataprovider.persistence.entity.TaskEntity;
import io.github.keillabezerra.task_manager_api.application.domain.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface TaskMapper {

    Task toDomain(final TaskEntity entity);

    List<Task> toDomain(final List<TaskEntity> entities);

    @Mapping(target = "id", source = "id", conditionExpression = "java(domain.getId() != 0)")
    TaskEntity toEntity(final Task domain);

}
