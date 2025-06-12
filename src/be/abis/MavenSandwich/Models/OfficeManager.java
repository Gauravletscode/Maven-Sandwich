package be.abis.MavenSandwich.Models;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;

import be.abis.MavenSandwich.Repository.FileOrdersRepository;
import be.abis.MavenSandwich.Repository.FileSandwichRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

import be.abis.MavenSandwich.Repository.FileSandwichRepository;


public class OfficeManager extends Person {

    FileSandwichRepository fsr;
    public OfficeManager(String lastName, String firstName, Gender gender) {
        super(lastName, firstName, gender);
    }
  public void printOrderOfToday() throws IOException {
      OrdersRepository or = new FileOrdersRepository();
      or.printTodayOrder();
  }
  public void printStatics() throws IOException {
      OrdersRepository or = new FileOrdersRepository();
      ((FileOrdersRepository)or).printStatics();

  }

  public void addSandwich(String sname , double price , String type  ) throws FileNotFoundException, SandwichNotFoundException {
      FileSandwichRepository fr = new FileSandwichRepository();
      try {
          fr.findtSandwichFromAvailabeList(sname);
      } catch (SandwichNotFoundException e) {
          System.out.println(e.getMessage());
          fr.addSandwichToAvailabeList(sname, price, type);
      }
  }


  public void printOrderByPerson(){

  }

  public void removeSandwich(String sname) throws SandwichNotFoundException {
    fsr.removeSandwichFromAvailabeList(sname);
  }

  public void calculatePrice(){

  }

  public void totalPricePerMonth (){

  }
}
