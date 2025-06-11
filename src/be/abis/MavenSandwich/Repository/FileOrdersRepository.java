package be.abis.MavenSandwich.Repository;

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
import java.util.List;

public class FileOrdersRepository implements OrdersRepository{
//C:\Users\Duser\IdeaProjects\Maven-Sandwich\src
    private List<Order> fileOrderList = new ArrayList<>();
    String fileLocation = "C:\\Users\\Duser\\IdeaProjects\\Maven-Sandwich\\src\\allOrders.csv";
    public FileOrdersRepository() throws Exception {
        this.readOrderFile();
    }

    private List<Order> readOrderFile() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\Duser\\IdeaProjects\\Maven-Sandwich\\src\\allOrders.csv");
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
/*
        if(tokens[6] == "yes") {sandwich.set      = true; } else { sandwich.set     = false;
        if(tokens[7] == "bruin" {  set ENUM }
        sandwich.setPrice = Double.parseDouble(tokens[8])
*/
        Order order = new Order(new Person(tokens[2],tokens[3]),sandwich);
        order.setOrderNumber(Integer.parseInt(tokens[0]));
        order.setOrderDate(LocalDate.parse(tokens[1],fmt));
        return order;
    }

    @Override
    public void addOrder(Order order) {
        // write to file
        this.writeOrderFile(order);
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

