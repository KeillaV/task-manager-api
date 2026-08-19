package io.github.keillabezerra.task_manager_api.entrypoint.api.controller;

import io.github.keillabezerra.task_manager_api.application.usecase.CreateTaskUseCase;
import io.github.keillabezerra.task_manager_api.entrypoint.api.mapper.TaskResponseMapper;
import io.github.keillabezerra.task_manager_api.factory.CreateTaskFactory;
import io.github.keillabezerra.task_manager_api.factory.TaskFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskControllerImplTest {

    @InjectMocks
    private TaskControllerImpl controller;
    @Mock
    private CreateTaskUseCase useCase;
    @Spy
    private TaskResponseMapper mapper = Mappers.getMapper(TaskResponseMapper.class);

    @Test
    void shouldCreateTask() {
        var request = CreateTaskFactory.buildRequest();
        var command = CreateTaskFactory.buildCommand(request);
        var task = TaskFactory.buildDomain(command);

        when(useCase.execute(command)).thenReturn(task);

        var result = controller.create(request);

        assertEquals(request.title(), result.title());
        assertEquals(request.description(), result.description());
        assertEquals(request.categoryId(), result.categoryId());
        assertEquals(request.priority(), result.priority().name());
        assertEquals(request.deadline(), result.deadline());

        verify(useCase).execute(command);
        verify(mapper).toResponse(task);
    }

}
