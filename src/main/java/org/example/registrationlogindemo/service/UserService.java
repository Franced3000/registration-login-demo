package org.example.registrationlogindemo.service;

import org.example.registrationlogindemo.entity.User;
import org.example.registrationlogindemo.dto.*;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
