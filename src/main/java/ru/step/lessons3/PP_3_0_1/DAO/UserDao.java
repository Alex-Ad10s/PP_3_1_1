package ru.step.lessons3.PP_3_0_1.DAO;


import ru.step.lessons3.PP_3_0_1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(Long id);
    void addUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
