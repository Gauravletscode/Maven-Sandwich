package be.abis.MavenSandwich.Models;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;
import be.abis.MavenSandwich.Repository.FileSandwichRepository;

public class OfficeManager extends Person {

    FileSandwichRepository fsr;
    public OfficeManager(String lastName, String firstName, Gender gender) {
        super(lastName, firstName, gender);
    }
  public void printOrderByDate(){

  }
  public void printOrderByPerson(){

  }
  public void addSandwich(String sname,double price){
    fsr.addSandwichToAvailabeList(sname,price);
  }
  public void removeSandwich(String sname) throws SandwichNotFoundException {
    fsr.removeSandwichFromAvailabeList(sname);
  }

  public void calculatePrice(){

  }
}
