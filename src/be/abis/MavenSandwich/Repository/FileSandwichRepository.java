package be.abis.MavenSandwich.Repository;



import be.abis.MavenSandwich.Models.Sandwich;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class FileSandwichRepository implements SandwichRepository {
    private List<Sandwich> sandwichesAvailable = new ArrayList<>();
    private List<Sandwich> sandwichesOrdered =  new ArrayList<>();


public FileSandwichRepository() throws FileNotFoundException {
    readSandwichFile();
}
private void readSandwichFile() throws FileNotFoundException {
    FileReader fr = new FileReader("C:\\Users\\Duser\\IdeaProjects\\Maven Sandwiches\\src\\sandwichesavailable.csv");
    try (BufferedReader reader = new BufferedReader(fr)){
        String currentLine = null;
        while((currentLine = reader.readLine()) != null) {
            sandwichesAvailable.add(parseSandwich(currentLine));
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

public Sandwich parseSandwich(String s){
        String[] tokens = s.split(";");
        Sandwich newSandwich = new Sandwich(tokens[0]);
        return newSandwich;
    }

    public void addsandwichOrdere(Sandwich s)  {
        sandwichesOrdered.add(s);
    }

    public void printAllSandwiches() {

        sandwichesAvailable.stream().forEach(System.out::println);

}



    }


