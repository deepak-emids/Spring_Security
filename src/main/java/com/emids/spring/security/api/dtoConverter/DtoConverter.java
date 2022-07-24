package com.emids.spring.security.api.dtoConverter;

import com.emids.spring.security.api.model.User;
import com.emids.spring.security.api.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConverter {
    public UserDto userToDto(User user) {
        UserDto user1 = new UserDto();
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());

        return user1;
    }

    public User dtoToUser(UserDto user) {
        User user1 = new User();
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());

        return user1;
    }

    public List<UserDto> userListToUserDtoList(List<User> users) {
        List<UserDto> UserDtoList = users.stream().map(user -> userToDto(user))
                .collect(Collectors.toList());
        return UserDtoList;
    }
}
