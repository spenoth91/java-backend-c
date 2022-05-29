package com.msglearning.javabackend.services;

import com.msglearning.javabackend.converters.UserConverter;
import com.msglearning.javabackend.entity.User;
import com.msglearning.javabackend.exceptions.InvalidUserException;
import com.msglearning.javabackend.repositories.UserRepository;
import com.msglearning.javabackend.to.UserTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(UserTO userTO) throws Exception {

        //validate Phone
        //validate email
        //check firstname NotNull or empty
        //check lastName NotNull or empty
        userTO.setPassword(PasswordService.getSaltedHash(userTO.getPassword()));
        //if (validateUserTO(userTO))
            return userRepository.save(UserConverter.convertToEntity(userTO));
        //else
            //throw new InvalidUserException("Invalid User data");
    }

    public static boolean validateUser (User user) {
        if (user.getEmail() == null || !user.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$"))
            return false;

        if (user.getFirstName() == null || user.getLastName() == null)
            return false;

        if (!user.getPhone().matches("^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$"))
            return false;

        if (user.getPassword() == null)
            return false;

        return true;
    }

    public static boolean validateUserTO (UserTO userTO) {
        if (userTO.getEmail() == null || !userTO.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$"))
            return false;

        if (userTO.getFirstName() == null || userTO.getLastName() == null)
            return false;

        if (!userTO.getPhone().matches("^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$"))
            return false;

        //if (userTO.getHashedPWD() == null)
            //return false;

        return true;
    }

    public List<UserTO> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            return Collections.emptyList();
        else
            return users.stream()
                    .map(UserConverter::convertToTO)
                    .collect(Collectors.toList());
    }

    public List<UserTO> findByName(String token) {
        List<User> users = userRepository.findByName(token);
        if (users.isEmpty())
            return Collections.emptyList();
        else
            return users.stream()
                    .map(UserConverter::convertToTO)
                    .collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<String> getProfileImage(Long userId) {
        return userRepository.findProfileImageById(userId);
    }

    public List<User> getGmailUsers() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .filter(u -> u.getEmail().endsWith("gmail.com"))
                .collect(Collectors.toList());

    }

    public List<String> getNamesSorted() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .map(u->u.getFirstName() + " " + u.getLastName())
                .sorted()
                .collect(Collectors.toList());

    }

    public boolean existsWithName(String name) {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .anyMatch(u-> u.getFirstName().contains(name) || u.getLastName().contains(name) );

    }

    public Map<String, List<User>> groupByRole() {
        List<User> allUsers = userRepository.findAll();

        Map<String, List<User>> toReturn = allUsers.
                stream().collect(Collectors.groupingBy(User::getRole));
        return toReturn;
    }

}
