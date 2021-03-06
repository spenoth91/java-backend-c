package com.msglearning.javabackend.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserTO implements Serializable {

    private Long id;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    //private byte[] hashedPWD;

    private String phone;

    private Integer role;
}
