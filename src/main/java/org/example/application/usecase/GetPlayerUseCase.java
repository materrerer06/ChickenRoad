package org.example.application.usecase;

import org.example.domain.model.Player;

public interface GetPlayerUseCase {
    Player getPlayer(String username);
}
