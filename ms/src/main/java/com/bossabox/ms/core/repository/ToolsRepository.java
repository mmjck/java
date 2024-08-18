package com.bossabox.ms.core.repository;
import com.bossabox.ms.core.repository.model.ToolsJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolsRepository extends JpaRepository<ToolsJpaModel, Long> {
    @Query(value = "SELECT * FROM tools WHERE tags like %:tag%", nativeQuery = true)
    List<ToolsJpaModel> findByTags(@Param("tag") String tag);
}
