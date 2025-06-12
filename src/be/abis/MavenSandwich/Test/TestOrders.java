package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;

import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;


import be.abis.MavenSandwich.Exceptions.TooManyOrderedException;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.FileOrdersRepository;
import be.abis.MavenSandwich.Repository.FileSandwichRepository;
import be.abis.MavenSandwich.Repository.MemoryOrdersRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestOrders {


    public static void main(String[] args) throws IOException {


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
        FileSandwichRepository sr = null;
        try {
             sr = new FileSandwichRepository();

        } catch (FileNotFoundException e ) {
            System.out.println(e.getMessage());;
        }

        p1 = new Person("senthil","R", Gender.MALE);
        or = new FileOrdersRepository();

        //        Sandwich s1 = new Sandwich("Salade de crabe",true, SandwichBreadType.Brown);
        try {

            order1= new Order(p1,sr.findtSandwichFromAvailabeList("Salade de thon"));
     //       order1.getSandwich().setSalade("");
            or.addOrder(order1);
        } catch (TooManyOrderedException  | SandwichNotFoundException e) {
            System.out.println(e.getMessage());
        }

              or.printTodayOrder();

        try {
            or.addOrder(new Order(new Person("Steve","Smith",Gender.MALE),new Sandwich("Salade de poulet",false,SandwichBreadType.Brown)));
        } catch (TooManyOrderedException e) {
            System.out.println(e.getMessage());;
        }

                  or.printTodayOrder();


        OrdersRepository or2 = new MemoryOrdersRepository() ;
        try {
            or2.addOrder(new Order(new Person("Tim","David",Gender.MALE),new Sandwich("Salade de poulet",false,SandwichBreadType.Brown)));
        } catch (TooManyOrderedException e) {
            System.out.println(e.getMessage());;
        }


    }
}
