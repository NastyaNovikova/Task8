package com.example.task8.dao;

import com.example.task8.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserDao {
    List<User> getAllUsers();
    void updateUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);


    void save(User user);
}
