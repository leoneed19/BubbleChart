package ru.mephi.bublechart.repository;


import ru.mephi.bublechart.users.User;

import java.util.List;

public interface UserRepository {

    User findByName(String userName);

    User addUser(User user);

    User editUser(User user);

    List<User> findAll();

    String findRoleByToken(String authorization);

    String findRoleNameByToken(String authorization);
}
