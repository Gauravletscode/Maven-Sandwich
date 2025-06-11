package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.FileSandwichRepository;

import java.io.FileNotFoundException;

public class TestSandwichRepo {
    public static void main(String[] args) throws FileNotFoundException, SandwichNotFoundException {
        FileSandwichRepository fr = new FileSandwichRepository();
        fr.printAllSandwiches();
    }
}
