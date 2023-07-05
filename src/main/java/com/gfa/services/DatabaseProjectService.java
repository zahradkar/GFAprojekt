package com.gfa.services;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.exceptions.InvalidIdException;
import com.gfa.exceptions.MissingNameException;
import com.gfa.exceptions.NameAlreadyExistsException;
import com.gfa.models.Project;
import com.gfa.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseProjectService implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public DatabaseProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> index() {
        return projectRepository.findAll();
    }

    @Override
    public Object store(ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException {
        if (projectRequestDto.getName() == null || projectRequestDto.getName().isEmpty())
            throw new MissingNameException("Name is required");

        if (projectRepository.existsByName(projectRequestDto.getName()))
            throw new NameAlreadyExistsException("Name already exists");

        Project project = new Project(projectRequestDto.getName(), projectRequestDto.getDescription());

        return projectRepository.save(project);
    }

    @Override
    public Object show(long id) throws InvalidIdException{
        if (!projectRepository.existsById(id))
            throw new InvalidIdException("Project not found");
        return projectRepository.findById(id);
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