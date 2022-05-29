package com.msglearning.javabackend.converters;

import com.msglearning.javabackend.entity.User;
import com.msglearning.javabackend.services.PasswordService;
import com.msglearning.javabackend.to.UserTO;

import java.util.Arrays;

public class UserConverter {

   /* public static final UserTO convertToTO(User entity) {
        return new UserTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                PasswordService.hash(entity.getPassword()),
                entity.getPhone()
        );
    }*/

    public static final UserTO convertToTO(User entity) {
        return new UserTO(entity.getId(), entity.getPassword(), entity.getFirstName(),
                entity.getLastName(), entity.getEmail(), entity.getPhone(), entity.getRole());
    }
    public static final User convertToUser (UserTO userTO) {
        User user = new User();

        user.setId(userTO.getId());
        user.setPassword("empty");
        user.setFirstName(userTO.getFirstName());
        user.setLastName(userTO.getLastName());
        user.setEmail(userTO.getEmail());
        user.setPhone(user.getPhone());
        user.setProfileImage("");

        return user;
    }

    public static final User convertToEntity(UserTO to) {
        return new User(to.getId(), to.getPassword(), to.getFirstName(), to.getLastName(), to.getEmail(), to.getPhone(), null, to.getRole(), null
        );
    }
}
