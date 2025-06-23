package fr.aitaddi.crud.service;

import fr.aitaddi.crud.entity.User;

import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email);

    List<User> getUsers();

    User findUserByUsername(String username);

    User updateUser(Long id,String newUsername, String newFirstName, String newLastName, String email) throws Exception;

    void deleteUser(String username);

}
