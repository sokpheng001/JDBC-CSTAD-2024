package model.service;

import model.Order;
import repository.OrderRepository;

import java.util.List;

public class OrderServiceImp implements OrderService{
    private final OrderRepository orderRepository = new OrderRepository();

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
