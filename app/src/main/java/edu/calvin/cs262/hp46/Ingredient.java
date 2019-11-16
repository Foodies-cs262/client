package edu.calvin.cs262.hp46;

public class Ingredient {
    private String ingriName;
    private Long ingriAmount;
    private String ingriUnit;

    public Ingredient(String ingriName, Long ingriAmount, String ingriUnit) {
        this.setAmount(ingriAmount);
        this.setName(ingriName);
        this.setUnit(ingriUnit);
    }

    public String getName() {
        return ingriName;
    }

    public void setName(String ingriName) {
        this.ingriName = ingriName;
    }

    public long getAmount() {
        return ingriAmount;
    }

    public void setAmount(Long ingriAmount) {
        this.ingriAmount = ingriAmount;
    }

    public String getUnit() {
        return ingriUnit;
    }

    public void setUnit(String ingriUnit) {
        this.ingriUnit = ingriUnit;
    }
}
