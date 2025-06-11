package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Models.Order;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface OrdersRepository {
    void addOrder(Order order);
    List<Order> findAllOrders() throws IOException, Exception;

    static String formatOrder(Order o) {
        StringBuilder sb = new StringBuilder("");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/M/d");
        sb.append(o.getOrderNumber()).append(";")
                .append(o.getOrderDate().format(dtf)).append(";")
                .append(o.getPerson().getLastName()).append(";")
                .append(o.getPerson().getFirstName()).append(";")
                .append(o.getPerson().getGender()).append(";")
                .append(o.getSandwich().getSandwichName()).append(";");
        System.out.println(sb);
      //          .append(o.getSandwich().get)
        //
        return sb.toString();
    }


}
