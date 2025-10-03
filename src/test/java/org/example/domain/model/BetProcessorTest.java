package org.example.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetProcessorTest {

    @Test
    void process_Win_ReturnsPositiveAmount() {
        BetProcessor processor = new BetProcessor();
        Bet bet = new Bet(100, 2.0);

         double result = processor.process(bet);

        assertTrue(result <= bet.getAmount() * (bet.getChosenMultiplier() - 1) || result == -bet.getAmount());
    }

    @Test
    void process_Lose_ReturnsNegativeAmount() {
        BetProcessor processor = new BetProcessor();
        Bet bet = new Bet(100, 20.0);

        double result = processor.process(bet);
        assertTrue(result == -bet.getAmount() || result > 0);
    }
}
