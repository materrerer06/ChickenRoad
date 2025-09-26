package org.example.application;

import org.example.domain.model.Chicken;
import org.example.domain.model.Road;
import org.example.domain.model.Bet;
import org.example.domain.model.Car;
import java.util.Random;

public class Game {

    private Chicken player;
    private Bet currentBet;
    private Road road;
    private Random random;

    public Game(Chicken player) {
        this.player = player;
        this.road = new Road();
        this.random = new Random();
    }

    public void startGame(double betAmount) {
        this.currentBet = new Bet(betAmount);

        while (player.isAlive() && player.getPosition() < 5) {
            road.printRoad();
            player.move();

            if (road.isBlocked(player.getPosition())) {
                player.die();
                System.out.println("Zderzenie z pojazdem! Gra skończona.");
                break;
            }

            if (player.getPosition() == 5) {
                if (attemptToCrossRoad()) {
                    System.out.println("Gratulacje! Udało Ci się przejść przez drogę!");
                    double winnings = currentBet.getWinnings();
                    System.out.println("Wygrałeś: " + winnings + " zł");
                }
            }
        }
    }

    private boolean attemptToCrossRoad() {
        double chance = random.nextDouble();
        if (chance <= 0.2) {
            currentBet.setMultiplier(1.25 * 1.25);
            return true;
        }
        return false;
    }
}
