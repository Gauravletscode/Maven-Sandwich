package be.abis.MavenSandwich.Repository;

import be.abis.MavenSandwich.Models.Sandwich;

import java.time.format.DateTimeFormatter;

public interface SandwichRepository {

    static String formatSandwich(Sandwich s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.getSandwichName()).append(";").
                append(s.getSandwichPrice());
        return sb.toString();
    }
}
