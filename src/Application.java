import controller.UserController;

public class Application {
    private static final UserController userController = new UserController();
    public static void main(String[] args) {
        userController.addUser();
    }
}
