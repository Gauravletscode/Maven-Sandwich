package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Exceptions.PersonNotFoundException;
import be.abis.MavenSandwich.Models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    List<Person> personList = new ArrayList<Person>();


    public void addPerson(Person person){
        personList.add(person);
        this.findAllPerson();
    }
    public void findAllPerson(){
        for(Person p:personList){
            System.out.println("Person Number :"+p.getPersonNumber()+"First Name : "+p.getFirstName()+"Last Name : " +p.getLastName());
        }

    }
    public Person findByPersonNumber(int number) throws PersonNotFoundException {
        return personList.stream()
                .filter(p->p.getPersonNumber()==number)
                .findFirst()
                .orElseThrow(()->new PersonNotFoundException("Person not found"));
    }
    public Person findByFirstName(String firstName) throws PersonNotFoundException{
        return personList.stream()
                .filter(p->p.getFirstName().equalsIgnoreCase(firstName))
                .findFirst()
                .orElseThrow(()->new PersonNotFoundException("Person not found"));
    }
    public Person findByLastName(String lastName) throws PersonNotFoundException {
        return personList.stream()
                .filter(p->p.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(()->new PersonNotFoundException("Person not found"));
    }
}

