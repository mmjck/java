package com.bossabox.ms.core.repository.mapper;

import com.bossabox.ms.core.domain.model.Tools;
import com.bossabox.ms.core.repository.model.ToolsJpaModel;

import java.util.function.Function;

public class ToolsJpaModel2ToolsMapper implements Function<ToolsJpaModel, Tools> {
    public static Tools mapper(ToolsJpaModel t){
        return new ToolsJpaModel2ToolsMapper().apply(t);
    }

    @Override
    public Tools apply(ToolsJpaModel t) {
        return new Tools(t.getId(), t.getTitle(), t.getDescription(), t.getLink(), t.getTags());
    }
}
