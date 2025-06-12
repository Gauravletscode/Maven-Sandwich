package be.abis.MavenSandwich.main;

import be.abis.MavenSandwich.Repository.FileSandwichRepository;
import be.abis.MavenSandwich.Repository.SandwichRepository;

import java.io.FileNotFoundException;

public class TestSandwichRepo {
    public static void main(String[] args) throws FileNotFoundException {
        SandwichRepository sr = new FileSandwichRepository();
//        ((FileSandwichRepository)sr).printAllSandwiches();

    }
}
