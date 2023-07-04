package com.gfa.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProjectTest {

    @Test
    public void testProjectConstructor() {
        // Arrange
        String name = "Test Project";
        String description = "Test description";
        List<Instance> instances = new ArrayList<>();

        // Act
        Project project = new Project(name, description, instances);

        // Assert
        Assertions.assertEquals(name, project.getName());
        Assertions.assertEquals(description, project.getDescription());
        Assertions.assertEquals(instances, project.getInstances());
    }

//    @Test
//    public void testGetId() {
//        // Arrange
//        Long id = 1L;
//        Project project = new Project();
//        project.setId(id);
//
//        // Act
//        Long result = project.getId();
//
//        // Assert
//        Assertions.assertEquals(id, result);
//    }
}