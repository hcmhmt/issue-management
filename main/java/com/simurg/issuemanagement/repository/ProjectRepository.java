package com.simurg.issuemanagement.repository;

import com.simurg.issuemanagement.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getByProjectCode(String projectCode);

    List<Project> getAllByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String name);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

}