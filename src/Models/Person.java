package Models;

public class Person {
    String firstName;
    String lastName;
    int personNumber;
    Enum Gender;

    public Person(String lastName, String firstName, Enum gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        Gender = gender;
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

    public Enum getGender() {
        return Gender;
    }

    public void setGender(Enum gender) {
        Gender = gender;
    }
    public void orderSandwich(){

    }
}
