package com.simurg.issuemanagement.api;


import com.simurg.issuemanagement.dto.IssueDto;
import com.simurg.issuemanagement.service.impl.IssueServiceImpl;
import com.simurg.issuemanagement.util.ApiPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    @Autowired
    private IssueServiceImpl issueServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueServiceImpl.getById(id));
    }

    @PostMapping
    public ResponseEntity<IssueDto> create(@Valid @RequestBody IssueDto project) {
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> update(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto project) {
        return ResponseEntity.ok(issueServiceImpl.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

}
