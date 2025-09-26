package org.example.Infrastructure.inmemory;

import org.example.domain.model.Bet;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

class BetTest {

    @Test
    void testInitialValues() {
        Bet bet = new Bet(100.0);

        assertEquals(100.0, bet.getAmount());
        assertEquals(1.0, bet.getMultiplier());
        assertEquals(100.0, bet.getWinnings());
    }

    @Test
    void testSetMultiplier() {
        Bet bet = new Bet(50.0);
        bet.setMultiplier(2.5);

        assertEquals(2.5, bet.getMultiplier());
        assertEquals(125.0, bet.getWinnings());
    }

    @Test
    void testZeroAmount() {
        Bet bet = new Bet(0.0);
        bet.setMultiplier(5.0);

        assertEquals(0.0, bet.getWinnings());
    }

    @Test
    void testNegativeMultiplier() {
        Bet bet = new Bet(100.0);
        bet.setMultiplier(-1.0);

        assertEquals(-100.0, bet.getWinnings());
    }
}
