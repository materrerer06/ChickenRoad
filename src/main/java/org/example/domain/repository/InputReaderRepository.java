package org.example.domain.repository;

public interface InputReaderRepository {
    double readBetAmount(double balance);
    double readMultiplier();
    boolean askContinue();
}
