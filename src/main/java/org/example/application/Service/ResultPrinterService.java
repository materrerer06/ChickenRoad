package org.example.application.Service;

import org.example.application.usecase.ResultPrinterUseCase;
import org.example.domain.model.Bet;
import org.example.domain.repository.ResultPrinterRepository;

public class ResultPrinterService implements ResultPrinterUseCase {

    private final ResultPrinterRepository printerRepository;

    public ResultPrinterService(ResultPrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    @Override
    public void displayResult(Bet bet, double rolledMultiplier, boolean win) {
        printerRepository.printResult(bet, rolledMultiplier, win);
    }
}
