package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Models.Person;

import java.util.Scanner;

public class UserInput {
    PersonRepository pr = new PersonRepository();
    public void userInput(){
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

}
}
