package org.example.dao;

import org.example.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserDaoImplTest {
    private static final User VALID_USER = new User("Плутоний");
    private static final User INVALID_USER = new User("Сергей");
    private static final UserDao DAO = new UserDaoImpl();


    @Test
    void shouldReturnUserByName() {
        assertEquals(VALID_USER, DAO.getUserByName(VALID_USER.getName()));
    }

    @Test
    void shouldReturnNullWhenUserDoesNotExist() {
        assertNull(DAO.getUserByName(INVALID_USER.getName()));
    }

}