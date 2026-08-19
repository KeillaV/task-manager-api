package io.github.keillabezerra.task_manager_api.application.domain;

import io.github.keillabezerra.task_manager_api.factory.CategoryFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CategoryTest {

    @Test
    void shouldBeEqualAndHaveSameHashCode() {
        var category = CategoryFactory.buildDomain();
        var otherCategory = CategoryFactory.buildDomain();

        assertEquals(category, otherCategory);
        assertEquals(category.hashCode(), otherCategory.hashCode());
    }

    @Test
    void shouldNotBeEqualAndNotHaveSameHashCode() {
        var category = CategoryFactory.buildDomain();
        var otherCategory = new Category(1, "example name 2", "example description");

        assertNotEquals(category, otherCategory);
        assertNotEquals(category.hashCode(), otherCategory.hashCode());
    }

}
