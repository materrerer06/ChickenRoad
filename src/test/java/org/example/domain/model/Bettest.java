package org.example.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bettest {

    @Test
    void constructor_SetsFieldsCorrectly() {
        Bet bet = new Bet(150, 3.5);

        assertEquals(150, bet.getAmount());
        assertEquals(3.5, bet.getChosenMultiplier());
    }

    @Test
    void negativeAmount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Bet(-10, 2.0));
    }

    @Test
    void invalidMultiplier_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Bet(100, 0.5));
    }
}
