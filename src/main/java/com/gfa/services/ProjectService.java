package com.gfa.services;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.exceptions.InvalidIdException;
import com.gfa.exceptions.MissingNameException;
import com.gfa.exceptions.NameAlreadyExistsException;
import com.gfa.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> index();

    Object store(ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException;

    Object show(long id) throws InvalidIdException;

    Object update();

    Object destroy();
}