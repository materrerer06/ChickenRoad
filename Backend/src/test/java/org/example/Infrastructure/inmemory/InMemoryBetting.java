package org.example.Infrastructure.inmemory;

import org.example.domain.model.Bet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetTest {

    @Test
    void shouldCalculatePotentialWinningsCorrectly() {
        Bet bet = new Bet(100, 2.5);
        assertEquals(250, bet.getPotentialWinnings(), 0.001);
    }
}
