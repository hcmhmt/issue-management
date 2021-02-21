package com.simurg.issuemanagement.api;


import com.simurg.issuemanagement.dto.ProjectDto;
import com.simurg.issuemanagement.service.impl.ProjectServiceImpl;
import com.simurg.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = "Project APIs")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        log.info("ProjectController-> GetById : " + id);
        return ResponseEntity.ok(projectServiceImpl.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create Project Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> create(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Project Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> update(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Project Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }

}
