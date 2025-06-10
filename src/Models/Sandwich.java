package Models;
import Enum.SandwichBreadType;

public class Sandwich {
    private String sandwichName;
    private boolean salade;
    private Enum sandwichBreadType;

    public Sandwich (String sandwichName, boolean salade, SandwichBreadType sandwichBreadType) {
        this.sandwichName = sandwichName;
        this.salade = salade;
        this.sandwichBreadType = sandwichBreadType;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }
}

