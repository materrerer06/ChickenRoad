package org.example.domain;

import org.example.domain.exceptions.InsufficientBalanceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerDomainTest {

    @Test
    void withdrawShouldReduceBalance() {
        Player player = new Player("Test", 100);
        player.withdraw(50);
        assertEquals(50, player.getBalance());
    }

    @Test
    void withdrawShouldThrowIfNotEnoughBalance() {
        Player player = new Player("Test", 50);
        assertThrows(InsufficientBalanceException.class, () -> player.withdraw(100));
    }
}
