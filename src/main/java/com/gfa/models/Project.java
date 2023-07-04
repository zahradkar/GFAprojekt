package com.gfa.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Instance> instances;

    public Project(String name, String description, List<Instance> instances) {
        this.name = name;
        this.description = description;
        this.instances = instances;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Instance> getInstances() {
        return instances;
    }
}