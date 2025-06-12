package be.abis.MavenSandwich.Repository;



import be.abis.MavenSandwich.Exceptions.SandwichNotFoundException;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.JsonUtils;

public class FileSandwichRepository implements SandwichRepository {
    private List<Sandwich> sandwichesAvailable = new ArrayList<>();
    private List<Sandwich> sandwichesOrdered = new ArrayList<>();
    static Logger myLogError = LogManager.getLogger("exceptionLogger");
    static Logger myLoginfo = LogManager.getRootLogger();


    public FileSandwichRepository() throws FileNotFoundException {
        readSandwichFile();
    }

    private void readSandwichFile() throws FileNotFoundException {
        FileReader fr = new FileReader("C:\\Users\\Duser\\IdeaProjects\\Maven Sandwiches\\src\\sandwichesavailable.csv");
        try (BufferedReader reader = new BufferedReader(fr)) {
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                sandwichesAvailable.add(parseSandwich(currentLine));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Sandwich parseSandwich(String s) {
        String[] tokens = s.split(";");
        Sandwich newSandwich = new Sandwich(tokens[0],Double.parseDouble(tokens[1]),tokens[2]);
        return newSandwich;
    }

    public void addsandwichOrdered(Sandwich s) {
        sandwichesOrdered.add(s);
    }

    public void printMenu() {
        sandwichesAvailable.sort(Comparator.comparing(Sandwich::getSandwichType));
        System.out.println("-".repeat(50));
        System.out.format("%-25s\n","Maven Sandwich");
        System.out.println("-".repeat(50));
        System.out.format("%-10s%-20s%-10s\n","Name","Veggie Yes or no","Brown/White");
        System.out.println("-".repeat(50));
        for (Sandwich sandwich : sandwichesAvailable) {
            System.out.format("%-10s%-20s%-10s",
                    sandwich.getSandwichName()," ", " " );
            System.out.println();
        }
    }


    public void addSandwichToAvailabeList(String sname , double price,String type) {
        Sandwich s = new Sandwich(sname,price,type);
        if (!sandwichesAvailable.contains(s)) {
            Path path = Paths.get("C:\\Users\\Duser\\IdeaProjects\\Maven Sandwiches\\src\\sandwichesavailable.csv");
            try (BufferedWriter writer =
                         Files.newBufferedWriter(path, Charset.forName("UTF-8")
                                 , StandardOpenOption.APPEND)) {
                writer.newLine();
                writer.write(SandwichRepository.formatSandwich(s));
                sandwichesAvailable.add(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            myLogError.info("Sandwich Added");
        }
    }
    public void removeSandwichFromAvailabeList (String sname) throws SandwichNotFoundException {
        Sandwich sToRemove = findtSandwichFromAvailabeList(sname);
        sandwichesAvailable.remove(sToRemove);
        System.out.println(sandwichesAvailable);
        Path path = Paths.get("C:\\Users\\Duser\\IdeaProjects\\Maven Sandwiches\\src\\sandwichesavailable.csv");
        try (BufferedWriter writer =
             Files.newBufferedWriter(path, Charset.forName("UTF-8")
                   , StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING)) {
             for (Sandwich sandwich : sandwichesAvailable) {
                  writer.write(SandwichRepository.formatSandwich(sandwich));
                  writer.newLine();
                  }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
    public Sandwich findtSandwichFromAvailabeList (String sandwichName) throws SandwichNotFoundException {
        Sandwich s1 = sandwichesAvailable.stream()
                .filter(s -> s.getSandwichName().equals(sandwichName))
                .findFirst()
                .orElseThrow(() -> new SandwichNotFoundException("Sorry Sandwich Not found"));
        return s1;
        }
    }








