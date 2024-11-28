package com.solarvalley.service;

import com.solarvalley.dto.UserDTO;
import com.solarvalley.entities.User;
import com.solarvalley.exceptions.UserAlreadyExistException;

public interface UserService {

    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);
    User createUser(UserDTO userDTO) throws UserAlreadyExistException;
    User updateUser(UserDTO userDTO);
    void deleteUserByEmail(String email);
}
