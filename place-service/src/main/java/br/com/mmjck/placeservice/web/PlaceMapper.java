package br.com.mmjck.placeservice.web;

import br.com.mmjck.placeservice.api.PlaceResponseDTO;
import br.com.mmjck.placeservice.domain.Place;

public class PlaceMapper {
    public static PlaceResponseDTO fromPlaceToResponse(Place place){
        return new PlaceResponseDTO(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
