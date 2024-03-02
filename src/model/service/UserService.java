package model.service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int insertUser(User user);
    int deleteUserById(int id);
    int updateUserById(int id, User user);
}
