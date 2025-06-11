package be.abis.MavenSandwich.Models;

import be.abis.MavenSandwich.Enum.SandwichBreadType;

public class Sandwich {
    private String sandwichName;
    private boolean salade;
    private Enum sandwichBreadType;
    private double sandwichPrice;

    public Sandwich (String sandwichName, boolean salade, SandwichBreadType sandwichBreadType) {
        this.sandwichName = sandwichName;
        this.salade = salade;
        this.sandwichBreadType = sandwichBreadType;
    }

    public Sandwich(String sandwichName, double sandwichPrice) {
        this.sandwichName = sandwichName;
        this.sandwichPrice = sandwichPrice;
    }

    public Sandwich(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public double getSandwichPrice() {
        return sandwichPrice;
    }

    public void setSandwichPrice(float sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    public boolean isSalade() {
        return salade;
    }

    public void setSalade(boolean salade) {
        this.salade = salade;
    }

    public Enum getSandwichBreadType() {
        return sandwichBreadType;
    }

    public void setSandwichBreadType(Enum sandwichBreadType) {
        this.sandwichBreadType = sandwichBreadType;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "sandwichName='" + sandwichName + '\'' +
                ", salade=" + salade +
                ", breadType=" + sandwichBreadType +
                ", Price = " + sandwichPrice +
                '}';
    }
}

