package com.yarops.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yarops.springboot.dao.UserDao;
import com.yarops.springboot.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional
    public void userEditor(User user, Long id) {
        userDao.userEditor(user, id);
    }
}
