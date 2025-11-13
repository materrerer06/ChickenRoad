package org.example.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PlayerRequest {
    @NotBlank(message = "Nazwa gracza nie może być pusta")
    private String username;

    @Min(value = 0, message = "Saldo początkowe musi być >= 0")
    private double initialBalance;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public double getInitialBalance() { return initialBalance; }
    public void setInitialBalance(double initialBalance) { this.initialBalance = initialBalance; }
}
