package com.uol.ms.service;

import com.uol.ms.controller.dto.CreatePlayerDto;
import com.uol.ms.infra.CodinamesHandler;
import com.uol.ms.model.GroupType;
import com.uol.ms.model.Player;
import com.uol.ms.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    final private PlayerRepository repository;
    final private CodinamesHandler handler;

    public PlayerService(PlayerRepository repository, CodinamesHandler handler) {
        this.repository = repository;
        this.handler = handler;
    }

    public Player create(CreatePlayerDto dto) {
        Player player = new Player(dto.name(), dto.email(), dto.phone(), dto.groupType());
        player.setCodiName(getCodiname(dto.groupType()));
        return this.repository.save(player);
    }

    public List<Player> getAll(){
        return this.repository.findAll();
    }

    private String getCodiname(GroupType type){
        return this.handler.findCodiname(type);
    }

}
