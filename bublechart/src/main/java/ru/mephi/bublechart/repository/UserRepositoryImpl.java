package ru.mephi.bublechart.repository;

import org.springframework.stereotype.Component;
import ru.mephi.bublechart.users.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("a");
        user.setRole("ADMIN");
        user.setPassword("1");
        user.setRealName("Админ");

        users.add(user);

        user = new User();
        user.setName("u");
        user.setRole("USER");
        user.setPassword("1");
        user.setRealName("Пользователь");

        users.add(user);
    }

    @Override
    public User findByName(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User editUser(User user) {
        for (User user1 : users) {
            if (user1.getName().equals(user.getName())) {
                user1.setToken(user.getToken());
                return user1;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public String findRoleByToken(String token) {
        for (User user : users) {
            if (user.getToken()!= null && user.getToken().equals(token)) {
                return user.getRole();
            }
        }
        return null;
    }

    @Override
    public String findRoleNameByToken(String token) {
        for (User user : users) {
            if (user.getToken()!= null && user.getToken().equals(token)) {
                return user.getName();
            }
        }
        return null;
    }
}
