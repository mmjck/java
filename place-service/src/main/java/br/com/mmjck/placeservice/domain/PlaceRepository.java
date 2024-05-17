package br.com.mmjck.placeservice.domain;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;


public interface PlaceRepository extends ReactiveCrudRepository<Place, Long>{ 

    @Query("SELECT * FROM place WHERE UPPER(name) = UPPER(:name);")
    Flux<Place> findByName(String name);
}
