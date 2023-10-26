package ch.juventus.bootdemo.persistance;

import ch.juventus.bootdemo.model.Order;

import java.util.Set;

public interface Database {

    Order readOrder(long id);

    Set<Order> readOrders();

    long createOrder(Order newOrder);

    long updateOrder(long id, Order updatedOrder);

    long deleteOrder(long id);

}
