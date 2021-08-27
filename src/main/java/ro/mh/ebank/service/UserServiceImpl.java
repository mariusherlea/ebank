package ro.mh.ebank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ro.mh.ebank.exception.ResourceNotFoundException;
import ro.mh.ebank.model.User;
import ro.mh.ebank.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(long id, User userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        userRepository.delete(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException(id);
        }

//		User post = postRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        //return post;
    }
}