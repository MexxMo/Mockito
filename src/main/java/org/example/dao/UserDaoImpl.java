package org.example.dao;


import org.example.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final List<User> users;

    public UserDaoImpl() {
        users = List.of(
                new User("Плутоний"),
                new User("Блесна"));
    }


    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }
}
