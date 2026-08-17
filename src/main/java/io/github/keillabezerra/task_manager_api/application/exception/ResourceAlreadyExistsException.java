package io.github.keillabezerra.task_manager_api.application.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(final String resourceName, final String field, final String value) {
        super("A " + resourceName + " with " + field + " " + value + " already exists");
    }

}
