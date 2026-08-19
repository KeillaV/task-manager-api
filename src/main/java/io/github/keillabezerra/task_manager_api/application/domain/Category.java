package io.github.keillabezerra.task_manager_api.application.domain;

import java.time.LocalDateTime;

public class Category {

    private long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;

    public Category() {
        this.createdAt = LocalDateTime.now();
    }

    public Category(final long id, final String name, final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public static Category of(final String name, final String description) {
        var category = new Category();
        category.setName(name);
        category.setDescription(description);
        return category;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
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
        var result = this.name.hashCode();
        result = 31 * result + this.description.hashCode();
        result = 31 * result + Long.hashCode(this.id);
        return result;
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

        return this.id == other.getId() &&
                this.name.equals(other.getName()) &&
                this.description.equals(other.getDescription());
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description;
    }

}
