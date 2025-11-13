package org.example.web.mapper;

import org.example.domain.model.Player;
import org.example.web.dto.response.PlayerResponse;
import org.springframework.stereotype.Component;

@Component
public class PlayerWebMapper {
    public PlayerResponse toResponse(Player player) {
        return new PlayerResponse(player.getUsername(), player.getBalance());
    }
}
