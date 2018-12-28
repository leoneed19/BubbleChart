package ru.mephi.bublechart.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.bublechart.repository.UserRepository;
import ru.mephi.bublechart.users.User;
import ru.mephi.bublechart.web.dto.AuthRequestDto;
import ru.mephi.bublechart.web.dto.AuthResponseDto;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/token")
    public ResponseEntity<?> auth(@RequestBody AuthRequestDto body)  {

        User byName = userRepository.findByName(body.getUserName());

        if (byName == null || !body.getPassword().equals(byName.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String token = UUID.randomUUID().toString();

        byName.setToken(token);
        userRepository.editUser(byName);

        AuthResponseDto answer = new AuthResponseDto();

        answer.setUserName(byName.getName());
        answer.setRole(byName.getRole());
        answer.setRealName(byName.getRealName());

        answer.setToken(token);

        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
