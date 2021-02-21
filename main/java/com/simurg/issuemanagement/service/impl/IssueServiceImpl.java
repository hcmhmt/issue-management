package com.simurg.issuemanagement.service.impl;

import com.simurg.issuemanagement.dto.IssueDto;
import com.simurg.issuemanagement.dto.ProjectDto;
import com.simurg.issuemanagement.entity.Issue;
import com.simurg.issuemanagement.repository.IssueRepository;
import com.simurg.issuemanagement.service.IssueService;
import com.simurg.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        Optional.ofNullable(issue.getDate())
                .orElseThrow(() -> new IllegalArgumentException("Issue date cannot be empty!"));

        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb = issueRepository.save(issueDb);

        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return modelMapper.map(issueRepository.getOne(id), IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);

        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));

        return page;

    }

    @Override
    public IssueDto update(Long id, IssueDto issue) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }
}
