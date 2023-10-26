package ch.juventus.bootdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Order {

    private final long id;
    private final String name;
    private final Set<Item> items;

    public Order(@JsonProperty("id") long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
        this.items = new HashSet<>();
    }

    public Order(long id, String name, Set<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItems(Set<Item> newItems) {
        items.addAll(newItems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(name, order.name) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, items);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
