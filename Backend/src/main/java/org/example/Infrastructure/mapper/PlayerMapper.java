package org.example.Infrastructure.mapper;

import org.example.domain.model.Player;
import org.example.Infrastructure.entity.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerEntity toEntity(Player player) { return new PlayerEntity(player.getUsername(), player.getBalance()); }
    public Player toDomain(PlayerEntity entity) { return new Player(entity.getUsername(), entity.getBalance()); }
}
