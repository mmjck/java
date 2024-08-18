package com.bossabox.ms.input.rest.dto;

import java.util.List;

public record ToolsResponseDto(
        Long id,
        String title,
        String link,
        String description,
        List<String> tags
) {
}
