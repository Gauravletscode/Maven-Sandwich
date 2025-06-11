package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.MemoryOrdersRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;

public class TestOrders {
    public static void main(String[] args) {
        Person p1 = new Person("Kode","Harshad", Gender.MALE);
        //replace sanwich creation objects by 
        Sandwich s1 = new Sandwich("Salade de crabe",true, SandwichBreadType.Brown);
        Order order1= new Order("10/06/2025",p1,s1);
        order1.printInfo();

        OrdersRepository or = new MemoryOrdersRepository() ;
        or.addOrder(new Order("10/06/2025",new Person("Tim","David",Gender.MALE),new Sandwich("Salade de poulet",false,SandwichBreadType.Brown)));


    }
}
