package org.example.web.dto.response;

public class PlayerResponse {
    private String username;
    private double balance;

    public PlayerResponse(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() { return username; }
    public double getBalance() { return balance; }
}
