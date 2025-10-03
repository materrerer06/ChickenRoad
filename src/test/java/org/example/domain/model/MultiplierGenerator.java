package org.example.domain.model;

import java.util.Random;

public class MultiplierGenerator {

    private final Random random = new Random();

    public double generate() {
        double min = 1.1;
        double max = 20.0;
        double value = min + (random.nextDouble() * (max - min));
        return Math.round(value * 100.0) / 100.0;
    }
}
