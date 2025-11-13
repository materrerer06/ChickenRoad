package org.example.domain.model;

import org.example.domain.exceptions.BettingException;

public class Bet {
    private final double amount;
    private final double multiplier;

    public Bet(double amount, double multiplier) {
        if (amount <= 0) throw new BettingException("Kwota zakładu musi być dodatnia");
        if (multiplier < 1.1) throw new BettingException("Mnożnik musi być >= 1.1");
        this.amount = amount;
        this.multiplier = multiplier;
    }

    public double getAmount() { return amount; }
    public double getMultiplier() { return multiplier; }
    public double calculateWin() { return amount * multiplier; }
}
