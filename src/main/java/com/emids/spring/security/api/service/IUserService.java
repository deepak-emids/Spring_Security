package com.emids.spring.security.api.service;

import com.emids.spring.security.api.model.User;
import com.emids.spring.security.api.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User addAdmin(UserDto user);
    User addUser(UserDto user);
    List<User> getAllUser();

}
