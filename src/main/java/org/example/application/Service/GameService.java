package org.example.application.Service;

import org.example.application.Game;
import org.example.domain.model.Chicken;

public class GameService {

    public void startNewGame(double betAmount) {
        Chicken chicken = new Chicken();
        Game game = new Game(chicken);
        game.startGame(betAmount);
    }
}
