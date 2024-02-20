package controller;

import model.User;
import service.UserService;
import service.UserServiceImp;

import java.util.List;
import java.util.UUID;

public class UserController {
    private final UserService userService = new UserServiceImp();
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    public int addUser(){
        return userService.insertUser(
          new User(1, UUID.randomUUID().toString(),"Koko","kokok123@gmail.com","12212",false)
        );
    }
}
