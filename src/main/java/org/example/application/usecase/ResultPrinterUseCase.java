package org.example.application.usecase;

import org.example.domain.model.Bet;

public interface ResultPrinterUseCase {
    void displayResult(Bet bet, double rolledMultiplier, boolean win);
}
