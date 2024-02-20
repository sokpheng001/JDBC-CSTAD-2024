package service;

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
}
