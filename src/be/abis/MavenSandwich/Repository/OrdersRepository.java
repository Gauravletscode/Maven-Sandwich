package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Exceptions.TooManyOrderedException;
import be.abis.MavenSandwich.Models.Order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface OrdersRepository {
    void addOrder(Order order) throws TooManyOrderedException;
    List<Order> findAllOrders() throws IOException, Exception;
    void printTodayOrder() throws FileNotFoundException;

    static String formatOrder(Order o) {
        StringBuilder sb = new StringBuilder("");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/M/d");
        sb.append(o.getOrderNumber()).append(";")
                .append(o.getOrderDate().format(dtf)).append(";")
                .append(o.getPerson().getLastName()).append(";")
                .append(o.getPerson().getFirstName()).append(";")
                .append(o.getPerson().getGender()).append(";")
                .append(o.getSandwich().getSandwichName()).append(";")
                .append(o.getSandwich().isSalade()?"yes":"no").append(";")
                .append(o.getSandwich().getSandwichBreadType()).append(";")
                .append(o.getSandwich().getSandwichPrice());
        System.out.println(sb);
      //          .append(o.getSandwich().get)
        //
        return sb.toString();
    }


}
