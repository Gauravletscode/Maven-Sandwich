package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.FileOrdersRepository;
import be.abis.MavenSandwich.Repository.MemoryOrdersRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;

public class TestOrders {
    public static void main(String[] args) {
        Person p1 = new Person("Kode","Harshad", Gender.MALE);
        //replace sandwich creation objects by find sandwich
        Sandwich s1 = new Sandwich("Salade de crabe",true, SandwichBreadType.Brown);
        Order order1= new Order(p1,s1);
        order1.printInfo();
        System.out.println(OrdersRepository.formatOrder(order1));

        OrdersRepository or = null;
        try {
            or = new FileOrdersRepository();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        or.addOrder(order1);
        or.addOrder(new Order(new Person("Tim","David",Gender.MALE),new Sandwich("Salade de poulet",false,SandwichBreadType.Brown)));


        System.out.println("\nAll orders:");
        try {
            System.out.println(or.findAllOrders());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
