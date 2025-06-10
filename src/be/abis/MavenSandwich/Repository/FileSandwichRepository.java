package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.SandwichRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSandwichRepository implements SandwichRepository {
    private List<Sandwich> sandwiches = new ArrayList<>();


private void readSandwichFile() throws FileNotFoundException {
    FileReader fr = new FileReader("sandwiches.csv");
    try (BufferedReader reader = new BufferedReader(fr)){
        String currentLine = null;
        while((currentLine = reader.readLine()) != null) {
            sandwiches.add(parseSandwich(currentLine));
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

public Sandwich parseSandwich(String s){
        String[] tokens = s.split(";");
        Sandwich newSandwich = new Sandwich(tokens[0],Integer.parseInt(tokens[1]),Double.parseDouble(tokens[2]),tokens[3]);
//        addCourse(cnew);
        return newSandwich;
    }
}

