package org.example.Infrastructure.inmemory;

import org.example.domain.model.Player;
import org.example.domain.repository.PlayerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPlayerRepository implements PlayerRepository {

    private final Map<String, Player> storage = new HashMap<>();

    @Override
    public Optional<Player> findByUsername(String username) {
        return Optional.ofNullable(storage.get(username));
    }

    @Override
    public void save(Player player) {
        storage.put(player.getUsername(), player);
    }
}
