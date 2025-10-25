package com.mycompany.platforme_telemedcine.Services;

import com.mycompany.platforme_telemedcine.Models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    void deleteUser(Long id);
    User updateUser(User user);
    User getUserByRole(String role);
    User getUserByEmail(String email);
}
