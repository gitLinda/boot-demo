package ch.juventus.bootdemo.persistance;

import ch.juventus.bootdemo.model.Item;
import ch.juventus.bootdemo.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryDatabase implements Database {

    private final Map<Long, Order> orders;

    public InMemoryDatabase() {
        orders = new HashMap<>();
        Order order1 = new Order(1, "order1");
        order1.addItem(new Item(1, "item1"));
        orders.put(order1.getId(), order1);
    }

    @Override
    public Order readOrder(long id) {
        return orders.get(id);
    }

    @Override
    public Set<Order> readOrders() {
        return new HashSet<>(orders.values());
    }

    public long createOrder(Order newOrder) {
        long nextId = getNextId();
        orders.put(nextId, new Order(nextId, newOrder.getName(), newOrder.getItems()));
        return newOrder.getId();
    }

    @Override
    public long updateOrder(long id, Order updatedOrder) {
        if (!orders.containsKey(id)) {
            return -1;
        }
        orders.put(id, updatedOrder);
        return updatedOrder.getId();
    }

    @Override
    public long deleteOrder(long id) {
        Order removedOrder = orders.remove(id);
        if (removedOrder == null) {
            return -1;
        }
        return id;
    }

    private long getNextId() {
        Optional<Long> highestId = orders.keySet().stream().max(Long::compare);
        return highestId.map(id -> id + 1).orElse(1L);
    }

}
