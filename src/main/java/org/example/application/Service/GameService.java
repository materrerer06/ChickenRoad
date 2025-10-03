package org.example.application.Service;

import org.example.application.usecase.GameUseCase;
import org.example.domain.exceptions.GameOverException;
import org.example.domain.model.Bet;
import org.example.domain.repository.BetRepository;
import org.example.domain.model.InputReader;
import org.example.domain.model.BetProcessor;

import java.util.ArrayList;
import java.util.List;

public class GameService implements GameUseCase {

    private final BetRepository betRepository;
    private final List<Bet> betHistory = new ArrayList<>();
    private final InputReader inputReader = new InputReader(System.in);
    private final BetProcessor betProcessor = new BetProcessor();

    private boolean gameRunning = false;
    private double balance = 1000.0;

    public GameService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @Override
    public void startGame() {
        gameRunning = true;
        System.out.println("🎰 Gra LIMBO rozpoczęta!");
        System.out.println("💰 Twoje początkowe saldo: " + String.format("%.2f", balance) + " zł\n");

        try {
            while (gameRunning && balance > 0) {
                System.out.println("Aktualne saldo: " + String.format("%.2f", balance) + " zł");

                double betAmount = inputReader.readBetAmount(balance);
                double multiplier = inputReader.readMultiplier();

                Bet bet = new Bet(betAmount, multiplier);

                double result = betProcessor.process(bet);

                balance += result;

                placeBet(bet);

                if (balance <= 0) {
                    throw new GameOverException("💸 Masz 0 zł. Koniec gry.");
                }

                gameRunning = inputReader.askContinue();
            }
        } catch (GameOverException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Koniec gry. Twoje końcowe saldo: " + String.format("%.2f", balance) + " zł");
    }

    @Override
    public void placeBet(Bet bet) {
        if (!gameRunning) {
            throw new IllegalStateException("Gra nie jest uruchomiona.");
        }
        betRepository.save(bet);
        betHistory.add(bet);
    }

    @Override
    public List<Bet> getBetHistory() {
        return List.copyOf(betHistory);
    }

    @Override
    public void endGame() {
        gameRunning = false;
        System.out.println("Gra zakończona");
    }
}
