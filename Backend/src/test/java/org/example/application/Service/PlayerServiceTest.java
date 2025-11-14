package org.example.application.Service;

import org.example.domain.model.Player;
import org.example.infrastructure.repository.InMemoryPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {

    private PlayerService service;

    @BeforeEach
    void setup() {
        service = new PlayerService(new InMemoryPlayerRepository());
        service.createPlayer("Adam", 100);
    }

    @Test
    void testCreateAndGetPlayer() {
        Player player = service.getPlayer("Adam");
        assertEquals(100, player.getBalance());
    }

    @Test
    void testPlaceBetUpdatesBalance() {
        double newBalance = service.placeBet("Adam", 10, 2.0);
        assertTrue(newBalance >= 90);
    }
}
