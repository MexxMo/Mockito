package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.dao.UserDao;
import org.example.model.User;
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public boolean checkUserExist(User user) {
        return userDao.getUserByName(user.getName()) != null;
    }
}
