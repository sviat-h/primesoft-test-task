package com.primesoft.service.impl;

import com.primesoft.dao.UserDao;
import com.primesoft.lib.annotation.Inject;
import com.primesoft.lib.annotation.Service;
import com.primesoft.model.User;
import com.primesoft.service.AuthenticationService;
import java.util.NoSuchElementException;
import javax.security.sasl.AuthenticationException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserDao userDao;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User userFromDb = userDao.findByLogin(login).orElseThrow(()
                -> new NoSuchElementException("There is no user with login: " + login));
        if (userFromDb.getPassword().equals(password)) {
            System.out.println("User with login: " + login + " is authenticated.");
            return userFromDb;
        } else {
            throw new AuthenticationException("Invalid password for user with login: " + login);
        }
    }
}
