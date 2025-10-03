package org.example.domain.model;

import org.example.domain.repository.InputReaderRepository;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class InputReader implements InputReaderRepository {

    private final Scanner scanner;

    public InputReader(InputStream in) {
        this.scanner = new Scanner(Objects.requireNonNull(in, "InputStream nie może być nullem"));
    }

    @Override
    public double readBetAmount(double balance) {
        while (true) {
            System.out.print("Ile chcesz obstawić? ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("❗ Kwota musi być większa niż 0.");
                    continue;
                }
                if (amount > balance) {
                    System.out.println("❗ Nie masz wystarczających środków.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("❗ Wpisz poprawną liczbę.");
            }
        }
    }

    @Override
    public double readMultiplier() {
        while (true) {
            System.out.print("Na jaki mnożnik grasz? (np. 2.5): ");
            try {
                double multiplier = Double.parseDouble(scanner.nextLine());
                if (multiplier < 1.1) {
                    System.out.println("❗ Minimalny mnożnik to 1.1x");
                    continue;
                }
                return multiplier;
            } catch (NumberFormatException e) {
                System.out.println("❗ Wpisz poprawną liczbę.");
            }
        }
    }

    @Override
    public boolean askContinue() {
        while (true) {
            System.out.print("Czy chcesz grać dalej? (tak/nie): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("tak") || input.equals("t")) {
                return true;
            } else if (input.equals("nie") || input.equals("n")) {
                return false;
            } else {
                System.out.println("❗ Wpisz 'tak' lub 'nie'.");
            }
        }
    }
}
