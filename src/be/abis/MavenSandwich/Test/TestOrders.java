package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Exceptions.TooManyOrderedException;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.FileOrdersRepository;
import be.abis.MavenSandwich.Repository.MemoryOrdersRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;

public class TestOrders {

    public static void main(String[] args) throws TooManyOrderedException {
        Person p1 = new Person("SA","G", Gender.MALE);
        //replace sanwich creation objects by 
        Sandwich s1 = new Sandwich("Salade de crabe",true, SandwichBreadType.Brown);
        Order order1= new Order(p1,s1);
        Order order2= new Order(p1,s1);
        Order order3= new Order(p1,s1);
        Person p2 = new Person("Kode","Harshad", Gender.MALE);
        //replace sandwich creation objects by find sandwich
        Sandwich s2 = new Sandwich("Salade de crabe",true, SandwichBreadType.Brown);
        Order order4= new Order(p1,s1);
        order4.printInfo();
        System.out.println(OrdersRepository.formatOrder(order4));

        OrdersRepository or = null;
        try {
            or = new FileOrdersRepository();
            or.addOrder(order1);
            or.addOrder(new Order(new Person("Tim","David",Gender.MALE),new Sandwich("Salade de poulet",false,SandwichBreadType.Brown)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        System.out.println("\nAll orders:");
        try {
            System.out.println(or.findAllOrders());
            or.printTodayOrder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        OrdersRepository or2 = new MemoryOrdersRepository() ;
        or2.addOrder(new Order(new Person("Tim","David",Gender.MALE),new Sandwich("Salade de poulet",false,SandwichBreadType.Brown)));



    }
}
