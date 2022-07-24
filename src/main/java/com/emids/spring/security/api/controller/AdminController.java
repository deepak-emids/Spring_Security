package com.emids.spring.security.api.controller;

import com.emids.spring.security.api.dto.UserDto;
import com.emids.spring.security.api.dtoConverter.DtoConverter;
import com.emids.spring.security.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.emids.spring.security.api.model.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private DtoConverter converter;

    @PostMapping()
    public com.emids.spring.security.api.dto.UserDto addAdmin(@Valid @RequestBody com.emids.spring.security.api.dto.UserDto user) {
        User savedAdmin = userServiceImpl.addAdmin(user);
        com.emids.spring.security.api.dto.UserDto savedAdminDto = converter.userToDto(savedAdmin);
        return savedAdminDto;
    }

    @GetMapping()
    public List<UserDto> getAllUser() {
        List<User> savedAdmin = (List<User>) userServiceImpl.getAllUser();
        return converter.userListToUserDtoList(savedAdmin);
    }
}
