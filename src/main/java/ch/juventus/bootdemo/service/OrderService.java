package ch.juventus.bootdemo.service;

import ch.juventus.bootdemo.model.Order;

import java.util.Set;

public interface OrderService {

    Order readOrder(long id);

    Set<Order> readOrders();

    long createOrder(Order newOrder);

    long updateOrder(long id, Order updatedOrder);

    long deleteOrder(long id);

}
