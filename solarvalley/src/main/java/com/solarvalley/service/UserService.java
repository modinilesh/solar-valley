package com.solarvalley.service;

import com.solarvalley.dto.UserDTO;
import com.solarvalley.entities.User;

public interface UserService {

    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);
    User createUser(UserDTO userDTO);
    User updateUser(UserDTO userDTO);
    void deleteUserByEmail(String email);
}
