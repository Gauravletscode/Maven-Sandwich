package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class MemoryOrdersRepository implements OrdersRepository{

    private List<Order> orders = new ArrayList<Order>();
 //   static Logger exceptionLogger = LogManager.getLogger("exceptionLogger");
 //   static Logger info = LogManager.getRootLogger();


    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orders;
    }
}
