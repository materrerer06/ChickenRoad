package org.example.domain.repository;

import org.example.domain.model.Player;
import java.util.Optional;

public interface PlayerRepository {
    Optional<Player> findByUsername(String username);
    void save(Player player);
}
