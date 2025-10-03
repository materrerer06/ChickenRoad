package org.example.domain.repository;

import org.example.domain.model.Bet;

import java.util.List;
import java.util.Optional;

public interface BetRepository {
    void save(Bet bet);
    Optional<Bet> findById(String id);
    List<Bet> findAll();
    void deleteById(String id);
}
