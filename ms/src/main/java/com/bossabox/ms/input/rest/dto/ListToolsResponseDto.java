package com.bossabox.ms.input.rest.dto;

import java.util.List;

public record ListToolsResponseDto(
        int total,
        List<ToolsResponseDto> data
) {
}
