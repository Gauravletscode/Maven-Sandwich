package be.abis.MavenSandwich.Test;

import be.abis.MavenSandwich.Enum.Gender;
import be.abis.MavenSandwich.Enum.SandwichBreadType;
import be.abis.MavenSandwich.Models.Order;
import be.abis.MavenSandwich.Models.Person;
import be.abis.MavenSandwich.Models.Sandwich;
import be.abis.MavenSandwich.Repository.FileOrdersRepository;
import be.abis.MavenSandwich.Repository.MemoryOrdersRepository;
import be.abis.MavenSandwich.Repository.OrdersRepository;

public class TestOrders {
    public static void main(String[] args) throws Exception {
        FileOrdersRepository fo = new FileOrdersRepository();
        fo.printTodayOrder();


    }
}
