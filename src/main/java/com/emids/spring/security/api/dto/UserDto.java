package com.emids.spring.security.api.dto;

import com.emids.spring.security.api.model.roleType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class UserDto {
    private String username;
    private String password;
    private String email;
    private roleType role;
}
