package com.emids.spring.security.api.controller;

import com.emids.spring.security.api.dtoConverter.DtoConverter;
import com.emids.spring.security.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    /*@PreAuthorize("hasAnyRole('ADMIN')")*/
//    @PostMapping()
//    public String addUserByAdmin(@RequestBody User user) {
//
//        String pwd = user.getPassword();
//        String encryptPwd = passwordEncoder.encode(pwd);
//        user.setPassword(encryptPwd);
//        userRepository.save(user);
//        return "user added successfully...";
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping()
//    public String securedHello() {
//
//        return "Secured Hello";
//    }
//}
