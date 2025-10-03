package org.example;

import org.example.application.Service.GameService;
import org.example.Infrastructure.inmemory.InMemoryBetRepository;

public class Main {
    public static void main(String[] args) {
        InMemoryBetRepository betRepository = new InMemoryBetRepository();
        GameService gameService = new GameService(betRepository);

        gameService.startGame();

        System.out.println("\nHistoria zakładów:");
        gameService.getBetHistory().forEach(bet ->
                System.out.println("Zakład: " + bet.getAmount() + " zł, mnożnik: " + bet.getChosenMultiplier()));
    }
}
