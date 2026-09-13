package com.p1.service;

import java.util.List;

import com.p1.dto.UserRequestDTO;
import com.p1.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO request);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> searchUsers(String name);

    UserResponseDTO updateUser(
            Long id,
            UserRequestDTO request);

    void deleteUser(Long id);
}
