package fr.aitaddi.crud.service.impl;

import fr.aitaddi.crud.entity.User;
import fr.aitaddi.crud.repository.UserRepository;
import fr.aitaddi.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(String firstName, String lastName, String username, String email) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


    @Override
    public User updateUser(Long id, String newUsername,  String newFirstName, String newLastName, String email) throws Exception {
        User currentUser = userRepository.findById(id).get();
        currentUser.setUsername(newUsername);
        currentUser.setFirstName(newFirstName);
        currentUser.setLastName(newLastName);
        currentUser.setEmail(email);
        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findUserByUsername(username);
        userRepository.deleteById(user.getId());

    }
}
