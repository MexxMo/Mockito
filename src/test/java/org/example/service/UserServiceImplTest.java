package org.example.service;

import org.example.dao.UserDao;

import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class UserServiceImplTest {
    private static final User VALID_USER = new User("Плутоний");
    private static final User INVALID_USER = new User("Сергей");

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl out;

    @Test
    void shouldReturnTrueWhenUserExists() {
        when(userDao.getUserByName("Плутоний")).thenReturn(VALID_USER);
        assertTrue(out.checkUserExist(VALID_USER));
    }

    @Test
    void shouldReturnFalseWhenUserNotExists() {
        when(userDao.getUserByName("Сергей")).thenReturn(null);
        assertFalse(out.checkUserExist(INVALID_USER));
    }

}