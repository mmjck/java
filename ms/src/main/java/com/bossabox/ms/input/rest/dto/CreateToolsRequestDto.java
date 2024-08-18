package com.bossabox.ms.input.rest.dto;

import com.bossabox.ms.core.domain.model.Tools;

import java.util.List;

public record CreateToolsRequestDto(
        String title,
        String link,
        String description,
        List<String> tags

) {

    public Tools toModel(){
        return new Tools(title, link, description, tags);
    }
}
