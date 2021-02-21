package com.simurg.issuemanagement.service;

import com.simurg.issuemanagement.dto.ProjectDto;
import com.simurg.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    ProjectDto update(Long id, ProjectDto project);

    Boolean delete(Long id);
}
