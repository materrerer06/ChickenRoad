package org.example.domain.repository;

import org.example.domain.model.Bet;

public interface ResultPrinterRepository {
    void printResult(Bet bet, double rolledMultiplier, boolean win);
}
