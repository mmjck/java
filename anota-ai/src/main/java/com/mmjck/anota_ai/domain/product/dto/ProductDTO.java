package com.mmjck.anota_ai.domain.product.dto;

public record ProductDTO(
    String title,
    String ownerId, 
    String description,
    String categoryId,
    Integer price
) {
    
}
