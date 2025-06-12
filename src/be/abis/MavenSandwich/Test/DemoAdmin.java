package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;
import be.abis.MavenSandwich.Models.OfficeManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoAdmin {
    public static void main(String[] args) throws IOException, SandwichNotFoundException {
        OfficeManager om = new OfficeManager("Singh","Gaurav", Gender.MALE);
        om.addSandwich("Vegan",10.00,"Roll");
  //      om.removeSandwich();
//        om.printOrderOfToday();
//        om.printStatics();



    }
}
