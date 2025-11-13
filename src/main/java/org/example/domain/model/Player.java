package org.example.domain.model;

import org.example.domain.exceptions.InsufficientBalanceException;

public class Player {
    private final String username;
    private double balance;

    public Player(String username, double balance) {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("Nazwa użytkownika nie może być pusta");
        if (balance < 0) throw new IllegalArgumentException("Saldo nie może być ujemne");
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() { return username; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Kwota depozytu musi być większa od 0");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) throw new InsufficientBalanceException("Brak środków na koncie");
        balance -= amount;
    }
}
