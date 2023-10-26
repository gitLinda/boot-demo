package ch.juventus.bootdemo.service;

import ch.juventus.bootdemo.model.Order;
import ch.juventus.bootdemo.persistance.Database;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DefaultOrderService implements OrderService {

    private final Database database;

    public DefaultOrderService(Database database) {
        this.database = database;
    }

    @Override
    public Order readOrder(long id) {
        return database.readOrder(id);
    }

    @Override
    public Set<Order> readOrders() {
        return database.readOrders();
    }

    public long createOrder(Order newOrder) {
        return database.createOrder(newOrder);
    }

    @Override
    public long updateOrder(long id, Order updatedOrder) {
        return database.updateOrder(id, updatedOrder);
    }

    @Override
    public long deleteOrder(long id) {
        return database.deleteOrder(id);
    }
}
