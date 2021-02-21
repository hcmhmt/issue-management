package com.simurg.issuemanagement.api;

import com.simurg.issuemanagement.dto.UserDto;
import com.simurg.issuemanagement.entity.User;
import com.simurg.issuemanagement.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDto> add(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
