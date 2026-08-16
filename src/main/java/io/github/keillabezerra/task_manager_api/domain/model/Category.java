package io.github.keillabezerra.task_manager_api.domain.model;

import java.time.LocalDateTime;

public class Category {

    private String name;
    private String description;
    private LocalDateTime createdAt;

    public Category(final String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public Category of(final String name) {
        return new Category(name);
    }

    public Category of(final String name, final String description) {
        var category = new Category(name);
        category.setDescription(description);
        return category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        return 31 * this.name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Category)) {
            return false;
        }

        Category other = (Category) object;

        return this.name.equals(other.getName());
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\nDescrição: " + this.description;
    }

}
