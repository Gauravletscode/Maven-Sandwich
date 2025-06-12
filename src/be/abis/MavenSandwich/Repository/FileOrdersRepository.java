package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Exceptions.PersonNotFoundException;
import be.abis.MavenSandwich.Exceptions.TooManyOrderedException;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOrdersRepository implements OrdersRepository{
//C:\Users\Duser\IdeaProjects\Maven-Sandwich\src
    private List<Order> fileOrderList = new ArrayList<>();
    String fileLocation = "/temp/javaProject/allOrders.csv";
    public FileOrdersRepository() throws Exception {
        this.readOrderFile();
    }

    private List<Order> readOrderFile() throws IOException {
        FileReader fr = new FileReader("/temp/javaProject/allOrders.csv");
        try (BufferedReader reader = new BufferedReader(fr)) {
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                fileOrderList.add(parseOrder(currentLine));
            }
            return fileOrderList;
        }
    }


    public Order parseOrder(String s){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/M/d");

//orderNumber;orderDate,lastname,firstname,gender,sandwich_name,isSalad,breadType,price
        String[] tokens = s.split(";");
        Sandwich sandwich = new Sandwich(tokens[5]);
        Person person = new Person(tokens[2],tokens[3]);
        if(tokens[4] == "MALE") { person.setGender(Gender.MALE);}
        if(tokens[6] == "yes") {sandwich.setSalade(true); } else { sandwich.setSalade(false);}
        if(tokens[7] == "Brown") { sandwich.setSandwichBreadType(SandwichBreadType.Brown);}
        sandwich.setSandwichPrice(Double.parseDouble(tokens[8]));

        Order order = new Order(person,sandwich);
        order.setOrderNumber(Integer.parseInt(tokens[0]));
        order.setOrderDate(LocalDate.parse(tokens[1],fmt));
        return order;
    }


    @Override
    public void addOrder(Order order) throws TooManyOrderedException {
        // write to file

        long foundCount = fileOrderList.stream()
                .filter(o->o.getPerson()!=null)
                .filter(o->o.getOrderDate().equals(LocalDate.now()))
                .filter(o->o.getPerson().getPersonNumber() == order.getPerson().getPersonNumber())
                .count();


        if (foundCount > 1) throw new TooManyOrderedException("already 2 ordered");
        else this.writeOrderFile(order);


    }

    public void writeOrderFile(Order order){
        System.out.println("implement write orders to file");
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write( OrdersRepository.formatOrder(order));
            fileOrderList.add(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Order> findAllOrders() throws Exception {
            return fileOrderList;
        }



}

