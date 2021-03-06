package com.simurg.issuemanagement.service;

import com.simurg.issuemanagement.dto.UserDto;
import com.simurg.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername(String userName);

}
