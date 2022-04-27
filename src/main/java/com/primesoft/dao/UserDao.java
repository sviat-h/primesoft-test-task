package com.primesoft.dao;

import com.primesoft.model.User;
import java.util.Optional;

public interface UserDao {
    Optional<User> findByLogin(String login);
}
