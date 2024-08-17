package com.uol.ms.controller.dto;

import com.uol.ms.model.GroupType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreatePlayerDto(
        @NotNull String name,
        @Email @NotNull String email,
        @NotNull String phone,
        @NotNull GroupType groupType
) {
}
