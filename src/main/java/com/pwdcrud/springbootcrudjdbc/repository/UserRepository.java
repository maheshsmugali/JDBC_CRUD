package com.pwdcrud.springbootcrudjdbc.repository;


import com.pwdcrud.springbootcrudjdbc.entity.User;


import java.util.List;

public interface UserRepository {


    User saveUser(User user);
    User upadaterUser(User user);

    User getById(int id);
    User deleteById(int id);
    List<User> allUsers();
}
