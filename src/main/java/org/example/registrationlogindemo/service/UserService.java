package org.example.registrationlogindemo.service;

import org.example.registrationlogindemo.entity.User;
import org.example.registrationlogindemo.dto.*;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
