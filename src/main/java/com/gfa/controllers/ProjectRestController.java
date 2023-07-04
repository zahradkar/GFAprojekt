package com.gfa.controllers;

import com.gfa.dtos.ProjectRequestDto;
import com.gfa.dtos.ProjectResponseDto;
import com.gfa.exceptions.NameAlreadyExistsException;
import com.gfa.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projects")
public class ProjectRestController {
    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public ResponseEntity index() {
        // TODO entire method
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Object> store(@RequestBody ProjectRequestDto projectRequestDto) {
        try { // created = 201
            return ResponseEntity.status(HttpStatus.CREATED).body(projectService.store(projectRequestDto));
        } catch (Exception exception) {
            HttpStatus status = HttpStatus.BAD_REQUEST; // 400

            if (exception instanceof NameAlreadyExistsException)
                status = HttpStatus.CONFLICT; // 409

            return ResponseEntity.status(status).body(new ProjectResponseDto(exception.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable Long id) {
        // TODO entire method
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id) {
        // TODO entire method
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable Long id) {
        // TODO entire method
        return null;
    }
}