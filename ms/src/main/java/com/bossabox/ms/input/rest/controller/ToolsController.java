package com.bossabox.ms.input.rest.controller;

import com.bossabox.ms.input.rest.dto.CreateToolsRequestDto;
import com.bossabox.ms.input.rest.dto.ListToolsResponseDto;
import com.bossabox.ms.input.rest.dto.ToolsResponseDto;
import com.bossabox.ms.core.domain.model.Tools;
import com.bossabox.ms.service.ToolsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsController {
    private  final ToolsService service;
    public ToolsController(ToolsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ToolsResponseDto> create(@RequestBody CreateToolsRequestDto dto){
        Tools response = this.service.create(dto.title(), dto.description(), dto.link(), dto.tags());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();


        return ResponseEntity.created(uri).body(
                new ToolsResponseDto(
                        response.getId(),
                        response.getTitle(),
                        response.getLink(),
                        response.getDescription(),
                        response.getTags()
                )
        );
    }

    @GetMapping
    public ResponseEntity<ListToolsResponseDto> findByTags(@RequestParam(required = false) String tag){
        List<Tools> response = new ArrayList<>();
        if(tag == null){
            response.addAll(this.service.getAll());
        }else {
            response.addAll(this.service.findByTag(tag));
        }

        var data = response.stream().map(r ->  new ToolsResponseDto(
                r.getId(),
                r.getTitle(),
                r.getLink(),
                r.getDescription(),
                r.getTags()
        )).toList();

        return ResponseEntity.ok(new ListToolsResponseDto(data.size(), data));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        this.service.delete(id);
        return ResponseEntity.ok().body("Tools deleted");
    }
}
