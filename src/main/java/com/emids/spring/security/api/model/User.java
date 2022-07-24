package com.emids.spring.security.api.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String username;
    private String password;
    private String email;
    private roleType role;
}

