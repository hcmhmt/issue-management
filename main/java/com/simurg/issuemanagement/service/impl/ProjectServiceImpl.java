package com.simurg.issuemanagement.service.impl;

import com.simurg.issuemanagement.dto.ProjectDto;
import com.simurg.issuemanagement.entity.Project;
import com.simurg.issuemanagement.repository.ProjectRepository;
import com.simurg.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        if (projectRepository.getByProjectCode(project.getProjectCode()) != null)
            throw new IllegalArgumentException("Project Code Already Exist!");

        project.setId(projectRepository.save(modelMapper.map(project, Project.class)).getId());

        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        return modelMapper.map(projectRepository.getOne(id), ProjectDto.class);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project pro = projectRepository.getOne(id);
        Optional.ofNullable(pro)
                .orElseThrow(() -> new IllegalArgumentException("Project does not exist ID: " + id));

        Project check = projectRepository.getByProjectCode(project.getProjectCode());

        if ( check != null && check.getId() != pro.getId() )
            throw new IllegalArgumentException("Project Code Already Exist!");

        pro.setProjectCode(project.getProjectCode());
        pro.setProjectName(project.getProjectName());

        return modelMapper.map(projectRepository.save(pro), ProjectDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
