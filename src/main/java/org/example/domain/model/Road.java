package org.example.domain.model;

import org.example.domain.exceptions.OutOfBoundException;

import java.util.Random;

public class Road {

    private static final int ROAD_LENGTH = 5;
    private boolean[] lanes;
    private Random random;

    public Road() {
        this.lanes = new boolean[ROAD_LENGTH];
        this.random = new Random();
        generateTraffic();
    }

    private void generateTraffic() {
        for (int i = 0; i < ROAD_LENGTH; i++) {
            lanes[i] = random.nextBoolean();
        }
    }

    public boolean isBlocked(int position) throws OutOfBoundException {
        if (position < 0 || position >= ROAD_LENGTH) {
            throw new OutOfBoundException("Pozycja kurczaka poza drogą");
        }
        return lanes[position];
    }

    public void printRoad() {
        for (int i = 0; i < ROAD_LENGTH; i++) {
            if (lanes[i]) {
                System.out.print("X ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }
}
