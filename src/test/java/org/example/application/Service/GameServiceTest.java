package org.example.application.Service;

import org.example.Infrastructure.inmemory.InMemoryBetRepository;
import org.example.domain.model.Bet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setup() {
        gameService = new GameService(new InMemoryBetRepository());
        gameService.startGame();
    }

    @Test
    void placeBetShouldSaveBet() {
        Bet bet = new Bet(100, 2.0);
        gameService.placeBet(bet);
        assertFalse(gameService.getBetHistory().isEmpty());
        assertEquals(1, gameService.getBetHistory().size());
        assertEquals(bet, gameService.getBetHistory().get(0));
    }

    @Test
    void endGameShouldStopGame() {
        gameService.endGame();
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> gameService.placeBet(new Bet(50, 1.5)));
        assertEquals("Gra nie jest uruchomiona.", exception.getMessage());
    }
}
