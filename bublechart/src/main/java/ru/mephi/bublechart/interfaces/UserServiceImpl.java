package ru.mephi.bublechart.interfaces;


import ru.mephi.bublechart.repository.UserRepository;
import ru.mephi.bublechart.users.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByName(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.editUser(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
