package org.example.domain.model;

import java.util.Objects;

public class BetProcessor {

    private final MultiplierGenerator generator;
    private final ResultPrinter printer;

    public BetProcessor() {
        this(new MultiplierGenerator() {
        }, new ResultPrinter());
    }

    public BetProcessor(MultiplierGenerator generator, ResultPrinter printer) {
        this.generator = Objects.requireNonNull(generator, "MultiplierGenerator nie może być nullem");
        this.printer = Objects.requireNonNull(printer, "ResultPrinter nie może być nullem");
    }

    public double process(Bet bet) {
        double rolledMultiplier = generator.generate();
        boolean win = rolledMultiplier >= bet.getChosenMultiplier();

        printer.printResult(bet, rolledMultiplier, win);

        return win ? bet.getPotentialWinnings() : -bet.getAmount();
    }
}
