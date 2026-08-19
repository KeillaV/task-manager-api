package io.github.keillabezerra.task_manager_api.application.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String resourceName) {
        super("Resource not found: " + resourceName);
    }

}
