package org.example.application.Service;

import org.example.application.usecase.*;
import org.example.domain.model.Bet;
import org.example.domain.model.Player;
import org.example.domain.exceptions.InsufficientBalanceException;
import org.example.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements
        CreatePlayerUseCase,
        GetPlayerUseCase,
        UpdatePlayerBalanceUseCase,
        PlaceBetUseCase {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void createPlayer(String username, double initialBalance) {
        Player player = new Player(username, initialBalance);
        playerRepository.save(player);
    }

    @Override
    public Player getPlayer(String username) {
        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono gracza: " + username));
    }

    @Override
    public void updateBalance(String username, double newBalance) {
        Player player = getPlayer(username);
        double diff = newBalance - player.getBalance();
        if (diff > 0) player.deposit(diff);
        else player.withdraw(-diff);
        playerRepository.save(player);
    }

    @Override
    public double placeBet(String username, double amount, double multiplier) {
        Player player = getPlayer(username);
        if (amount > player.getBalance()) throw new InsufficientBalanceException("Brak środków");

        player.withdraw(amount);
        Bet bet = new Bet(amount, multiplier);

        boolean win = Math.random() > 0.5;
        if (win) player.deposit(bet.calculateWin());

        playerRepository.save(player);
        return player.getBalance();
    }
}
