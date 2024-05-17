package br.com.mmjck.placeservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mmjck.placeservice.api.PlaceRequestDTO;
import br.com.mmjck.placeservice.api.PlaceResponseDTO;

import br.com.mmjck.placeservice.domain.PlaceService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController( PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/")
    public ResponseEntity<Mono<PlaceResponseDTO>> create(@Valid @RequestBody PlaceRequestDTO dto) {
        var placeResponse = this.placeService.create(dto).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }


    @GetMapping()
    public ResponseEntity<Flux<PlaceResponseDTO>> getAll(@Nullable @RequestParam String name) {
        if(name != null){
            var places = this.placeService.findByName(name.toUpperCase()).map(PlaceMapper::fromPlaceToResponse);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(places);
        }

        var places = this.placeService.findAll().map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(places);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mono<PlaceResponseDTO>> getById(@PathVariable(value = "id") Long id) {
        var places = this.placeService.getById(id).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(places);
    }

}
