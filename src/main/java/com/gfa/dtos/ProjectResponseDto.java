package com.gfa.dtos;

public class ProjectResponseDto {
    private final String error;

    public ProjectResponseDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}