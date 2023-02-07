package com.pwdcrud.springbootcrudjdbc.repository;

import com.pwdcrud.springbootcrudjdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO user(id,fname,lname,email)values(?,?,?,?)";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET fname=? WHERE iD=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";
    private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFName(), user.getLName(), user.getEmail());
        return user;
    }

    @Override
    public User upadaterUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFName(), user.getId());

        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lName"), rs.getString("email"));
        },id);
    }

    @Override
    public User deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);

        return null;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        });    }
}
