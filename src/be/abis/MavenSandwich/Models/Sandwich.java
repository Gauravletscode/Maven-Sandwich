package Models;
import Enum.SandwichBreadType;


public class Sandwich {
    private String sandwichName;
    private boolean salade;
    private Enum breadType;

    public Sandwich (String sandwichName, boolean salade, SandwichBreadType breadType) {
        this.sandwichName = sandwichName;
        this.salade = salade;
        this.breadType = breadType;
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
}

