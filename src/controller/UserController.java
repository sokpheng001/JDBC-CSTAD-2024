package controller;

import model.User;
import org.junit.Test;
import service.Service;
import service.ServiceImp;

import java.util.List;

public class UserController {
    private final Service service = new ServiceImp();
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    public int addUser(){
        return service.insertUser(
          new User(1,"Koko","kokok123@gmail.com","12212",false)
        );
    }
}
