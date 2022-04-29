package com.primesoft.service;

import com.primesoft.model.User;
import javax.security.sasl.AuthenticationException;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
