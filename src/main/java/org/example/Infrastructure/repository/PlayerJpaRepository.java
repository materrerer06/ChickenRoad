package org.example.Infrastructure.repository;

import org.example.Infrastructure.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {
    Optional<PlayerEntity> findByUsername(String username);
}
