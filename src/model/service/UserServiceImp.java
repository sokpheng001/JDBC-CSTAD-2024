package model.service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserServiceImp implements UserService {
    private final UserRepository repository = new UserRepository();
    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }
    @Override
    public int insertUser(User user) {
        return repository.insertUser(user);
    }
    @Override
    public int deleteUserById(int id) {
        return repository.deleteUserById(id);
    }

    @Override
    public int updateUserById(int id, User user) {
        return repository.updateUserById(id, user);
    }
}
