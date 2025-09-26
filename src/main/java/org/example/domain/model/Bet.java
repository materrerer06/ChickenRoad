package org.example.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Bet {
    private final UUID id;
    private final double amount;        // Kwota zakładu
    private double multiplier;          // Mnożnik wygranej

    public Bet(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Bet amount must be greater than 0.");
        }

        this.id = UUID.randomUUID();
        this.amount = amount;
        this.multiplier = 1.0;
    }

    public UUID getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        if (multiplier <= 0) {
            throw new IllegalArgumentException("Multiplier must be greater than 0.");
        }
        this.multiplier = multiplier;
    }

    public double getWinnings() {
        return amount * multiplier;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", amount=" + amount +
                ", multiplier=" + multiplier +
                ", winnings=" + getWinnings() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bet bet)) return false;
        return Objects.equals(id, bet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
