package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Exceptions.PersonNotFoundException;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.MemoryOrdersRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;
import be.abis.MavenSandwich.Repository.PersonRepository;
import be.abis.MavenSandwich.Repository.UserInput;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestOrders {
    public static void main(String[] args) throws IOException {

        PersonRepository pr = new PersonRepository();
        pr.findAllPerson();
        UserInput usrInp = new UserInput();
        System.out.println("Enter Your details to proceed with Order :");
        usrInp.userInput();
        pr.findAllPerson();
}
    }

