package org.example.domain.model;

public class Bet {
    private final double amount;
    private final double chosenMultiplier;

    public Bet(double amount, double chosenMultiplier) {
        this.amount = amount;
        this.chosenMultiplier = chosenMultiplier;
    }

    public double getAmount() {
        return amount;
    }

    public double getChosenMultiplier() {
        return chosenMultiplier;
    }

    public double getPotentialWinnings() {
        return amount * chosenMultiplier;
    }
}
