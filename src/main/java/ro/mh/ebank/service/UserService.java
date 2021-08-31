package ro.mh.ebank.service;

import ro.mh.ebank.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserById(Long id);

}
