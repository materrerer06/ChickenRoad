package org.example.domain.model;

import org.example.domain.model.Bet;
import org.example.domain.repository.ResultPrinterRepository;

public class ResultPrinter implements ResultPrinterRepository {

    @Override
    public void printResult(Bet bet, double rolledMultiplier, boolean win) {
        System.out.println("🎲 Wylosowany mnożnik: " + String.format("%.2f", rolledMultiplier) + "x");
        if (win) {
            System.out.println("✅ Wygrałeś! Wygrana: " + String.format("%.2f", bet.getPotentialWinnings()) + " zł");
        } else {
            System.out.println("❌ Przegrałeś! Strata: " + String.format("%.2f", bet.getAmount()) + " zł");
        }
        System.out.println("--------------------------------\n");
    }
}
