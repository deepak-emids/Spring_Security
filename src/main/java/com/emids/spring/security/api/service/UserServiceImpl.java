package com.emids.spring.security.api.service;

import com.emids.spring.security.api.dtoConverter.DtoConverter;
import com.emids.spring.security.api.model.User;
import com.emids.spring.security.api.model.roleType;
import com.emids.spring.security.api.repository.UserRepository;
import com.emids.spring.security.api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private DtoConverter converter;

    @Override
    public User addAdmin(UserDto user) {
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);

        user.setPassword(encryptPwd);
        User converted = converter.dtoToUser(user);
        userRepository.save(converted);
        return converted;
    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();

        return userList;
    }
}
