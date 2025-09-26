package org.example;

import org.example.application.Service.GameService;

public class Main {

    public static void main(String[] args) {
        GameService gameService = new GameService();

        gameService.startNewGame(100);
    }
}
