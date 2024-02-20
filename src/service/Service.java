package service;

import model.User;

import java.util.List;

public interface Service {
    List<User> getAllUsers();
    int insertUser(User user);
}
