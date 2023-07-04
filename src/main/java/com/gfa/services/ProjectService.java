package com.gfa.services;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.exceptions.MissingNameException;
import com.gfa.exceptions.NameAlreadyExistsException;

public interface ProjectService {
    Object index();

    Object store(ProjectRequestDto projectRequestDto) throws MissingNameException, NameAlreadyExistsException, NameAlreadyExistsException;

    Object show();

    Object update();

    Object destroy();
}