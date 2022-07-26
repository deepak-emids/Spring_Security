package com.emids.spring.security.api.controller;

import com.emids.spring.security.api.model.User;
import com.emids.spring.security.api.dto.UserDto;
import com.emids.spring.security.api.dtoConverter.DtoConverter;
import com.emids.spring.security.api.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private DtoConverter converter;

    @GetMapping()
    public UserDto getUser(@Valid int id) {
        User foundUser = userServiceImpl.getUser(id);
        UserDto user = converter.userToDto(foundUser);
        return user;
    }

}