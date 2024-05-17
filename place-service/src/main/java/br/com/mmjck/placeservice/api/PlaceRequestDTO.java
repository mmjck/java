package br.com.mmjck.placeservice.api;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequestDTO(
    @NotBlank String name,
    @NotBlank String state
){
}
