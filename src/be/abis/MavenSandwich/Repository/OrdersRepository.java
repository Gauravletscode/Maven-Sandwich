package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Models.Order;

import java.util.List;

public interface OrdersRepository {
    void addOrder(Order order);
    List<Order> findAllOrders();


}
