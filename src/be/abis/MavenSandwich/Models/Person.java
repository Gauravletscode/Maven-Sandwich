package be.abis.MavenSandwich.Models;

import be.abis.MavenSandwich.Enum.Gender;

public class Person {
    static String firstName;
    static String lastName;
    public static int personNumber = 1;
    Gender gender;

    public Person(String lastName, String firstName, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void orderSandwich(){

    }
}
