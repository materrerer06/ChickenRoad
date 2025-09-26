package org.example.Infrastructure.inmemory;

import org.example.domain.model.Bet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("test")
public class InMemoryBetting {

    private final Map<UUID, Bet> storage = new HashMap<>();

    public UUID save(Bet bet) {
        UUID id = UUID.randomUUID();
        storage.put(id, bet);
        return id;
    }

    public Optional<Bet> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Bet> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void clear() {
        storage.clear();
    }
}
