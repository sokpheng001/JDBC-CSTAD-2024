package controller;

import model.Order;
import service.OrderService;
import service.OrderServiceImp;
import service.UserService;
import service.UserServiceImp;

import java.util.List;

public class OrderController {
    private final OrderService orderService = new OrderServiceImp();
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }
}
