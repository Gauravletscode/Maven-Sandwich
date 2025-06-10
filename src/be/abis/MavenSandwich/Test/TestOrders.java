package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;

public class TestOrders {
    public static void main(String[] args) {
        Person p1 = new Person("Kode","Harshad", Gender.MALE);
        Sandwich s1 = new Sandwich("Salade de crabe",true, SandwichBreadType.Brown);
        Order order1= new Order("10/06/2025",p1,s1);
        order1.printInfo();
    }
}
