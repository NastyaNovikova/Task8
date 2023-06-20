package com.example.task8.service;


import com.example.task8.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void updateUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
    void saveUser(User user);
}
