package com.gfa.services;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.dtos.ProjectResponseDto;
import com.gfa.exceptions.MissingNameException;
import com.gfa.exceptions.NameAlreadyExistsException;
import com.gfa.exceptions.ProjectNotFoundException;
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
        confirmName(projectRequestDto.getName());

        Project project = new Project(projectRequestDto.getName(), projectRequestDto.getDescription());

        return projectRepository.save(project);
    }

    @Override
    public Object show(String id) throws ProjectNotFoundException {
//        return projectRepository.findById(confirmId(id)).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        return projectRepository.findById(confirmId(id)).get();
    }

    @Override
    public Object update(String id, ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException, ProjectNotFoundException {
        confirmName(projectRequestDto.getName());

        Project project = projectRepository.findById(confirmId(id)).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        project.setName(projectRequestDto.getName());

        return projectRepository.save(project);
    }

    @Override
    public Object destroy(String id) throws ProjectNotFoundException {
        long confId = confirmId(id);
        System.out.println(confId);
        projectRepository.deleteById(confId);
        return null;
    }

    private long confirmId(String id) throws ProjectNotFoundException {
        long confirmedId;
        try {
            confirmedId = Long.parseLong(id);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Invalid id");
        }

        if (confirmedId < 0)
            throw new NumberFormatException("Invalid id");

        if (!projectRepository.existsById(confirmedId))
            throw new ProjectNotFoundException("Project not found");

        return confirmedId;
    }

    private void confirmName(String name) throws MissingNameException, NameAlreadyExistsException {
        if (name == null || name.isEmpty())
            throw new MissingNameException("Name is required");

        if (projectRepository.existsByName(name))
            throw new NameAlreadyExistsException("Name already exists");
    }
}