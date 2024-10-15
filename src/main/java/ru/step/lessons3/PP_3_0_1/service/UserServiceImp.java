package ru.step.lessons3.PP_3_0_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.step.lessons3.PP_3_0_1.DAO.UserDao;
import ru.step.lessons3.PP_3_0_1.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}