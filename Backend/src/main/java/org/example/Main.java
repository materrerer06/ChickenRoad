package org.example;

import org.example.application.InputReader;
import org.example.application.Service.PlayerService;
import org.example.domain.model.Bet;
import org.example.domain.model.Player;
import org.example.Infrastructure.inmemory.InMemoryPlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 🔧 Inicjalizacja zależności (repozytorium + serwis)
        InMemoryPlayerRepository playerRepository = new InMemoryPlayerRepository();
        PlayerService playerService = new PlayerService(playerRepository);
        InputReader inputReader = new InputReader();

        Scanner scanner = new Scanner(System.in);
        List<Bet> betHistory = new ArrayList<>();

        // 🧑 Tworzenie gracza
        System.out.print("Podaj nazwę gracza: ");
        String username = scanner.nextLine();

        playerService.createPlayer(username, 100);
        System.out.println("💰 Stworzono gracza " + username + " z saldem 100 zł.");

        boolean playing = true;
        while (playing) {
            Player player = playerService.getPlayer(username);
            System.out.println("\nSaldo: " + player.getBalance() + " zł");

            // 🎯 Pobranie danych zakładu
            double amount = inputReader.readBetAmount(player.getBalance());
            double multiplier = inputReader.readMultiplier();

            // 💸 Wykonanie zakładu
            double newBalance = playerService.placeBet(username, amount, multiplier);
            System.out.println("Nowe saldo: " + newBalance + " zł");

            // 🧾 Zapamiętaj zakład
            betHistory.add(new Bet(amount, multiplier));

            // 🔁 Czy kontynuować
            playing = inputReader.askContinue();
        }

        // 📜 Historia zakładów
        System.out.println("\n📜 Historia zakładów:");
        for (Bet bet : betHistory) {
            System.out.printf(" - Kwota: %.2f zł, mnożnik: %.2fx%n", bet.getAmount(), bet.getMultiplier());
        }

        System.out.println("\n👋 Koniec gry, dziękujemy za udział!");
    }
}
