package com.mmjck.anota_ai.domain.category.dto;

import com.mongodb.lang.NonNull;

public record CategoryDTO(
    @NonNull String title, 
    @NonNull String ownerId, 
    @NonNull String description) {
}
