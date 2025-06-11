package be.abis.MavenSandwich.Models;

import be.abis.MavenSandwich.Enum.SandwichBreadType;

public class Sandwich {
    private String sandwichName;
    private boolean salade;
    private SandwichBreadType sandwichBreadType;
    private double sandwichPrice;
    private String sandwichType;

    public Sandwich(String sandwichName, boolean salade, SandwichBreadType sandwichBreadType, String sandwichType, double sandwichPrice) {
        this.sandwichName = sandwichName;
        this.salade = salade;
        this.sandwichBreadType = sandwichBreadType;
        this.sandwichType = sandwichType;
        this.sandwichPrice = sandwichPrice;
    }



    public Sandwich (String sandwichName, boolean salade, SandwichBreadType sandwichBreadType) {
        this.sandwichName = sandwichName;
        this.salade = salade;
        this.sandwichBreadType = sandwichBreadType;
    }

    public Sandwich(String sandwichName, double sandwichPrice,String sandwichType) {
        this.sandwichName = sandwichName;
        this.sandwichPrice = sandwichPrice;
        this.sandwichType = sandwichType;
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

    public void setSandwichPrice(double sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    public boolean isSalade() {
        return salade;
    }

    public void setSalade(boolean salade) {
        this.salade = salade;
    }

    public SandwichBreadType getSandwichBreadType() {
        return sandwichBreadType;
    }

    public void setSandwichBreadType(SandwichBreadType sandwichBreadType) {
        this.sandwichBreadType = sandwichBreadType;
    }

    public String getSandwichType() {
        return sandwichType;
    }

    public void setSandwichType(String sandwichType) {
        this.sandwichType = sandwichType;
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

