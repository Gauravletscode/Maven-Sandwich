package be.abis.MavenSandwich.Models;
import be.abis.MavenSandwich.Enum.Gender;

public class Person implements Instructor,Student{
    String firstName;
    String lastName;
    int personNumber;
    private Gender gender;

    public Person(String lastName, String firstName, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void orderSandwich(){

    }

    @Override
    public void teachCourse() {

    }

    @Override
    public void attendCourse() {

    }
}
