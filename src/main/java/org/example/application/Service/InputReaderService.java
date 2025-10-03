package org.example.application.Service;

import org.example.application.usecase.InputReaderUseCase;
import org.example.domain.repository.InputReaderRepository;

public class InputReaderService implements InputReaderUseCase {

    private final InputReaderRepository inputReaderRepository;

    public InputReaderService(InputReaderRepository inputReaderRepository) {
        this.inputReaderRepository = inputReaderRepository;
    }

    @Override
    public double getBetAmount(double balance) {
        return inputReaderRepository.readBetAmount(balance);
    }

    @Override
    public double getMultiplier() {
        return inputReaderRepository.readMultiplier();
    }

    @Override
    public boolean continueGame() {
        return inputReaderRepository.askContinue();
    }
}
