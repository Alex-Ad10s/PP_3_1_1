package ru.step.lessons3.PP_3_0_1.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.step.lessons3.PP_3_0_1.model.User;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        List<User> usersList = new ArrayList<>();
        usersList = entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
        return usersList;
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser (User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser (Long id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

}
