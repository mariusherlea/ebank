package ro.mh.ebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mh.ebank.exception.ResourceNotFoundException;
import ro.mh.ebank.model.User;
import ro.mh.ebank.repository.UserRepository;


import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController extends BadRequestExceptionHandler{

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User is valid");
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody User userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }



}
