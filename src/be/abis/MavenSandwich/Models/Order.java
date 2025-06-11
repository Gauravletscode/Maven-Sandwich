package be.abis.MavenSandwich.Models;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {

    private int orderNumber;
    private LocalDate orderDate;
    private Person person;
    private Sandwich sandwich;
    private static int orderCount=0;
 //   DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public Order(Person person, Sandwich sandwich) {
        this.orderDate = orderDate.now();
        this.person = person;
        this.sandwich = sandwich;
        orderCount++;
        this.orderNumber = orderCount;
    }

    public Person getPerson() {
        return person;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void printInfo(){
        System.out.println(person.getFirstName() + ";" + person.getLastName() +";" + this.orderNumber+ ";" + this.orderDate + ";" + sandwich.toString());

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderDate='" + orderDate + '\'' +
                ", person=" + person +
                ", sandwich=" + sandwich +
                '}';
    }
}
