package com.uol.ms.controller.dto;

import java.util.List;

public record ListResponsePlayerDto(
        int total,
        List<ResponsePlayerDto> data
) {
}
