package org.example.application.usecase;

import org.example.domain.model.Bet;

import java.util.List;

public interface GameUseCase {
    void startGame();
    void placeBet(Bet bet);
    List<Bet> getBetHistory();
    void endGame();
}
