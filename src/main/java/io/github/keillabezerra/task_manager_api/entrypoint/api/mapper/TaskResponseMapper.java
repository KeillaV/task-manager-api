package io.github.keillabezerra.task_manager_api.entrypoint.api.mapper;

import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.TaskResponse;
import io.github.keillabezerra.task_manager_api.application.domain.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskResponseMapper {

    @Mapping(target = "categoryId", source = "category.id")
    TaskResponse toResponse(final Task domain);

}
