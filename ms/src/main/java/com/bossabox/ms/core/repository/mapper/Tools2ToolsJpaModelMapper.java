package com.bossabox.ms.core.repository.mapper;

import com.bossabox.ms.core.domain.model.Tools;
import com.bossabox.ms.core.repository.model.ToolsJpaModel;

import java.util.function.Function;

public class Tools2ToolsJpaModelMapper implements Function<Tools, ToolsJpaModel> {
    public static ToolsJpaModel mapper(final Tools t){
        return new Tools2ToolsJpaModelMapper().apply(t);
    }

    @Override
    public ToolsJpaModel apply(Tools t) {
        return new ToolsJpaModel(t.getId(), t.getTitle(), t.getDescription(), t.getLink(), t.getTags());
    }
}
