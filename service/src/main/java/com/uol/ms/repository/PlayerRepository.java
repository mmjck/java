package com.uol.ms.repository;

import com.uol.ms.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
