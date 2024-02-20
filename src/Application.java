import controller.OrderController;
import controller.UserController;
import model.Order;

public class Application {
    private static final UserController userController = new UserController();
    private static final OrderController orderController = new OrderController();
    public static void main(String[] args) {
        orderController.getAllOrder().stream().filter(order ->
            order.getUserId().getUserName().equalsIgnoreCase("koko")).forEach(e->{
            System.out.println(e.getUserId());
        });
    }
}
