package ru.mephi.bublechart.interfaces;


import ru.mephi.bublechart.users.User;

import java.util.List;

public interface UserService {

    User findByName(String userName);

    User addUser(User userBeforeSave);

    User editUser(User userAfterSave);

    List<User> findAll();
}
