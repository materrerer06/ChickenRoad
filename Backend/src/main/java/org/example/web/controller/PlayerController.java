package org.example.web.controller;

import org.example.application.Service.PlayerService;
import org.example.web.dto.request.PlayerRequest;
import org.example.web.dto.response.PlayerResponse;
import org.example.web.mapper.PlayerWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerWebMapper playerWebMapper;

    public PlayerController(PlayerService playerService, PlayerWebMapper playerWebMapper) {
        this.playerService = playerService;
        this.playerWebMapper = playerWebMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse createPlayer(@Valid @RequestBody PlayerRequest request) {
        playerService.createPlayer(request.getUsername(), request.getInitialBalance());
        return playerWebMapper.toResponse(playerService.getPlayer(request.getUsername()));
    }

    @GetMapping("/{username}")
    public PlayerResponse getPlayer(@PathVariable String username) {
        return playerWebMapper.toResponse(playerService.getPlayer(username));
    }
}
