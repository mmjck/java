package com.uol.ms.controller.dto;

import com.uol.ms.model.GroupType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ResponsePlayerDto(
        Long id,
        String codiname,
        String name,
        String email,
        String phone,
        GroupType groupType
) {
}
