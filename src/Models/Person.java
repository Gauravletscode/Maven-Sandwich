package Models;
import Enum.Gender;

public class Person {
    String firstName;
    String lastName;
    int personNumber;
    private Gender gender;

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

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void orderSandwich(){

    }
}
