package com.management.service;

import com.management.dao.UserDao;
import com.management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userdao;
    @Override
    public void newUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userdao.deleteUser(id);
    }

    @Override
    public User getUserByCF(String cf) {
        return userdao.getUserByDB(cf);
    }

    @Override
    public User getUserById(int id) {
        return userdao.getUserById(id);
    }

    @Override
    public boolean validate(String username, String password) {
        return userdao.Validate(username,password);
    }
}
