package ru.mephi.bublechart.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mephi.bublechart.repository.UserRepository;
import ru.mephi.bublechart.users.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    private UserService userService;

    List<User> list;

    User user1;
    User user2;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userRepository);
        list = new ArrayList<>();

        user1 = new User();
        user1.setName("A");
        user1.setId(1);
        user2 = new User();
        user2.setName("B");
        user2.setId(2);

        list.add(user1);
        list.add(user2);
    }

    @Test
    void findAllUsersTest() {
        Mockito.when(userRepository.findAll())
                .thenReturn(list);

        List<User> all = userService.findAll();

        assertEquals(2, all.size());
        assertArrayEquals(list.toArray(), all.toArray());
    }

    @Test
    void findAllUsersErrorTest() {
        Mockito.when(userRepository.findAll())
                .thenReturn(null);

        List<User> all = userService.findAll();

        assertNull(all);
    }

    @Test
    void findByUserNameTest() {
        Mockito.when(userRepository.findByName("A"))
                .thenReturn(user1);

        User user = userService.findByName("A");

        assertEquals(user1, user);
    }

    @Test
    void findByUserNameNotFoundTest() {
        Mockito.when(userRepository.findByName("C"))
                .thenReturn(null);

        User user = userService.findByName("C");

        assertNull(user);
    }

    @Test
    void addNewUserTest() {
        Mockito.when(userRepository.addUser(any()))
                .thenAnswer( inv -> {
                    User user = (User) inv.getArguments()[0];
                    user.setId(1234);
                    return user;
                });

        User user = userService.addUser(user1);

        assertEquals("A", user.getName());
        assertEquals(1234, (int)user.getId());
    }

    @Test
    void addNewUserFailTest() {
        Mockito.when(userRepository.addUser(any()))
                .thenReturn(null);

        User user = userService.addUser(user1);

        assertNull(user);
    }

    @Test
    void editUserTest() {
        Mockito.when(userRepository.editUser(any()))
                .thenAnswer( inv -> inv.getArguments()[0]);

        User user = userService.editUser(user1);

        assertEquals("A", user.getName());
        assertEquals(1, (int)user.getId());
    }

    @Test
    void editUserFailTest() {
        Mockito.when(userRepository.editUser(any()))
                .thenReturn(null);

        User user = userService.editUser(user1);

        assertNull(user);
    }
}
