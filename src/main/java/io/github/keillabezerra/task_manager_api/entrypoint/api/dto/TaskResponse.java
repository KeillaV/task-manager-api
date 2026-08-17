package io.github.keillabezerra.task_manager_api.entrypoint.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.keillabezerra.task_manager_api.application.enums.Priority;
import io.github.keillabezerra.task_manager_api.application.enums.Status;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TaskResponse (long id,
                            String title,
                            Status status,
                            String description,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
                            LocalDateTime deadline,
                            long categoryId,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
                            LocalDateTime createdAt,
                            Priority priority) {

}
