package be.abis.MavenSandwich.Models;


public class Order {

    private int orderNumber;
    private String orderDate;
    private Person person;
    private Sandwich sandwich;
    private static int orderCount=0;

    public Order(String orderDate, Person person, Sandwich sandwich) {
        this.orderDate = orderDate;
        this.person = person;
        this.sandwich = sandwich;
        orderCount++;
        this.orderNumber = orderCount;

    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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
