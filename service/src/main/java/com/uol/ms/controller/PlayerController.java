package com.uol.ms.controller;

import com.uol.ms.controller.dto.CreatePlayerDto;
import com.uol.ms.controller.dto.ListResponsePlayerDto;
import com.uol.ms.controller.dto.ResponsePlayerDto;
import com.uol.ms.model.Player;
import com.uol.ms.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    final private PlayerService service;
    public PlayerController(PlayerService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Player> create(@RequestBody @Valid CreatePlayerDto dto){
        Player response = service.create(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping
    public ResponseEntity<ListResponsePlayerDto> getAll(){
        var response = this.service.getAll().stream().map(r -> new ResponsePlayerDto(r.getId(), r.getCodiName(), r.getName(), r.getEmail(), r.getPhoneNumber(), r.getGroupType())).toList();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ListResponsePlayerDto(response.size(), response));
    }
}
