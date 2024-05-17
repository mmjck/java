package br.com.mmjck.placeservice.domain;

import com.github.slugify.Slugify;

import br.com.mmjck.placeservice.api.PlaceRequestDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository repository;
    private Slugify slg;
    
    
    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequestDTO dto){
        Place place = new Place(null, 
            dto.name(), 
            slg.slugify(dto.state()), 
            dto.state(), 
            null,
            null
            
        );
        return this.repository.save(place);
    }

    public Flux<Place> findAll(){
        return this.repository.findAll();
    }

    public Mono<Place> getById(Long id){
        return this.repository.findById(id);
    }

    public Flux<Place> findByName(String name){
        return this.repository.findByName(name);
    }
}
