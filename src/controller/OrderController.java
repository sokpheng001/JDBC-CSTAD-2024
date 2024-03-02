package controller;

import model.Order;
import model.service.OrderService;
import model.service.OrderServiceImp;

import java.util.List;

public class OrderController {
    private final OrderService orderService = new OrderServiceImp();
    public void getAllOrders(){
        orderService.getAllOrders().forEach(System.out::println);
    }
}
