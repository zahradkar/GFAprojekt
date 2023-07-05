package com.gfa.services;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.dtos.ProjectResponseDto;
import com.gfa.exceptions.ProjectNotFoundException;
import com.gfa.exceptions.MissingNameException;
import com.gfa.exceptions.NameAlreadyExistsException;
import com.gfa.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> index();

    Object store(ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException;

    Object show(String id) throws ProjectNotFoundException;

    Object update(String id, ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException, ProjectNotFoundException;

    Object destroy(String id) throws ProjectNotFoundException;
}