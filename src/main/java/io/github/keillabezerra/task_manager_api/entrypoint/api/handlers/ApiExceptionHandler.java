package io.github.keillabezerra.task_manager_api.entrypoint.api.handlers;

import io.github.keillabezerra.task_manager_api.application.exception.ResourceNotFoundException;
import io.github.keillabezerra.task_manager_api.entrypoint.api.dto.ErrorResponse;
import io.github.keillabezerra.task_manager_api.application.exception.ResourceAlreadyExistsException;
import org.springframework.http.HttpStatus;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleResourceAlreadyExistsException(final ResourceAlreadyExistsException exception) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),
                exception.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceAlreadyExistsException(final ResourceNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Input validation errors",
                errors);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericException(final Exception exception) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: " + exception.getMessage());
    }


}
