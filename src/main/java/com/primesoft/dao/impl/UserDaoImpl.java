package com.primesoft.dao.impl;

import com.primesoft.dao.UserDao;
import com.primesoft.exception.DataProcessingException;
import com.primesoft.lib.annotation.Dao;
import com.primesoft.model.User;
import com.primesoft.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> findByLogin(String login) {
        String query = "SELECT id, nick, login, password, insert_time "
                + "FROM users "
                + "WHERE login = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = getUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get user by login " + login, e);
        }
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String nick = resultSet.getString("nick");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        LocalDateTime insertTime = resultSet.getTimestamp("insert_time").toLocalDateTime();
        return User.builder().id(id).nick(nick).login(login).password(password)
                .insertTime(insertTime).build();
    }
}
