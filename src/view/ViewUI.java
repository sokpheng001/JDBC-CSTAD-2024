package view;

import controller.OrderController;
import controller.UserController;

import java.util.Locale;
import java.util.Scanner;

public class ViewUI {
    private final UserController userController = new UserController();
    private final OrderController orderController = new OrderController();
    private void home(){
        System.out.println("======================== CRUD OPERATION =========================");
        System.out.println("1. Get All User".toUpperCase(Locale.ROOT));
        System.out.println("2. INSERT USER".toUpperCase(Locale.ROOT));
        System.out.println("3. Search user by name".toUpperCase(Locale.ROOT));
        System.out.println("4. Delete user by ID".toUpperCase(Locale.ROOT));
        System.out.println("5. Update user by id".toUpperCase(Locale.ROOT));
        System.out.println("6. Product ORDER".toUpperCase(Locale.ROOT));
        System.out.println("=================================================================");
    }
    private void orderUI(){
        System.out.println("1. Get All Orders".toUpperCase(Locale.ROOT));
        System.out.println("2. INSERT order".toUpperCase(Locale.ROOT));
        System.out.println("3. Delete order by ID".toUpperCase(Locale.ROOT));
        System.out.println("=================================================================");
    }
    private int choose(){
        home();
        System.out.print("> Insert Option: ");
        return new Scanner(System.in).nextInt();
    }
    public void ui(){
        while (true){
            switch (choose()){
                case 1 -> userController.getAllUsers();
                case 2->userController.addUser();
                case 4 -> userController.deleteUserById();
                case 5 -> userController.updateUserById();
                case 6-> orderUI();
                default -> System.out.println("The wrong option!!!");
            }
        }
    }
}
