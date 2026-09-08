package com.example.learnhub.modules.users.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

class UserEntityMappingTest {

    @Test
    void userEntityShouldBeMappedToUsersTable() {
        Entity entity = user.class.getAnnotation(Entity.class);
        assertNotNull(entity, "The user entity must be annotated with @Entity");

        Table table = user.class.getAnnotation(Table.class);
        assertNotNull(table, "The user entity must declare the users table mapping");
        assertEquals("users", table.name());
    }
}
