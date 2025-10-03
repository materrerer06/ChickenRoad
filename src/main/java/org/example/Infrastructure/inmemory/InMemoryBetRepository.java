package org.example.Infrastructure.inmemory;

import org.example.domain.model.Bet;
import org.example.domain.repository.BetRepository;

import java.util.*;

public class InMemoryBetRepository implements BetRepository {

    private final Map<String, Bet> storage = new HashMap<>();

    @Override
    public void save(Bet bet) {
        storage.put(UUID.randomUUID().toString(), bet);
    }

    @Override
    public Optional<Bet> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Bet> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }
}
