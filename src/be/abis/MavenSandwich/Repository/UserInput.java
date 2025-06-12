package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;
import be.abis.MavenSandwich.Exceptions.TooManyOrderedException;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInput {
        PersonRepository pr = new PersonRepository();
        public void userInput() throws Exception {
                FileSandwichRepository fsr = new FileSandwichRepository();
                System.out.println("Enter first Name :");
                Scanner scanner = new Scanner(System.in);
                String firstName = scanner.nextLine();
                System.out.println("Enter Last Name :");
                Scanner scanner1 = new Scanner(System.in);
                String lastName = scanner1.nextLine();
                System.out.println("Choose Gender : MALE/FEMALE/OTHER");
                Scanner scanner2 = new Scanner(System.in);
                String genderInput = scanner2.nextLine();
                Gender gender = Gender.valueOf(genderInput);
                Person person = new Person(lastName, firstName, gender);
                pr.addPerson(person);
                System.out.println("Please choose Sandwiches from Menu Below :");
                fsr.printMenu();
                Scanner scanner4 = new Scanner(System.in);
                String sandwichName = scanner4.nextLine();
                System.out.println("Do you Need Salads Yes/No");

                Scanner scanner5 = new Scanner(System.in);
                String NeedSalad = scanner5.nextLine();
                Boolean   isSalad = false;
                if (NeedSalad.equalsIgnoreCase("yes")) {isSalad = true;}
         //       Boolean   isSalad = scanner5.nextBoolean();
                System.out.println("Type Of Bread Brown/White");
                Scanner scanner6 = new Scanner(System.in);
                String breadType = scanner6.nextLine();
    //            Sandwich sandwich = new Sandwich(sandwichName,isSalad, SandwichBreadType.valueOf(breadType));
                FileSandwichRepository sr = null;
                try {
                        sr = new FileSandwichRepository();

                } catch (FileNotFoundException e ) {
                        System.out.println(e.getMessage());;
                }
                Sandwich sandwich= sr.findtSandwichFromAvailabeList(sandwichName);
                sandwich.setSalade(isSalad);
                sandwich.setSandwichBreadType(SandwichBreadType.valueOf(breadType));

                OrdersRepository or = new FileOrdersRepository();
                try {
                        //how to set sawich typ and cread typ for below:
                        Order order1= new Order(person,sandwich);
                        or.addOrder(order1);

                } catch (TooManyOrderedException e) {
                        System.out.println(e.getMessage());


                }
        }}
