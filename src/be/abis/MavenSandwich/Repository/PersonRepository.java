package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    List<Person> personList = new ArrayList<>();{
        personList.add(new Person("Lynch","David", Gender.MALE ));
        personList.add(new Person("EastWood","Clint", Gender.MALE ));
        personList.add(new Person("Taylor","Elisabeth", Gender.FEMALE ));

        }


}
