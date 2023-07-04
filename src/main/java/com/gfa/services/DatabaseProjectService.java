package com.gfa.services;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.exceptions.MissingNameException;
import com.gfa.exceptions.NameAlreadyExistsException;
import com.gfa.models.Project;
import com.gfa.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseProjectService implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public DatabaseProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Object index() {
        return null;
    }

    @Override
    public Object store(ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException {
        if (projectRequestDto.getName().isEmpty() || projectRequestDto.getName() == null)
            throw new MissingNameException("Name is required");

        if (!projectRepository.existsByName(projectRequestDto.getName()))
            throw new NameAlreadyExistsException("Name already exists");

        Project project = new Project(projectRequestDto.getName(), projectRequestDto.getDescription(), projectRequestDto.getInstances());

        return projectRepository.save(project);
    }

    @Override
    public Object show() {
        return null;
    }

    @Override
    public Object update() {
        return null;
    }

    @Override
    public Object destroy() {
        return null;
    }
}