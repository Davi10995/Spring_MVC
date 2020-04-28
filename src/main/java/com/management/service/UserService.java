package com.management.service;

import com.management.model.User;

import java.util.List;

public interface UserService {

    void newUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserByCF(String cf);
    User getUserById(int id);
    List<User> getUsers();
    boolean validate(String username, String password);
}
