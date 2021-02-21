package com.simurg.issuemanagement.service.impl;

import com.simurg.issuemanagement.dto.UserDto;
import com.simurg.issuemanagement.entity.User;
import com.simurg.issuemanagement.repository.UserRepository;
import com.simurg.issuemanagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        user = userRepository.save(user);
        UserDto map = modelMapper.map(user, UserDto.class);

        return map;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        //return userRepository.findByUsername(username);
        return null;
    }

}
