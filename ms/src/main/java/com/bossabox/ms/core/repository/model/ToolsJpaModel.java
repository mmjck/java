package com.bossabox.ms.core.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
//@Table(name = "tools")
public class ToolsJpaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private String link;
    private List<String> tags;

    public ToolsJpaModel(Long id, String title, String description, String link, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.tags = tags;
    }

    public ToolsJpaModel(String title, String description, String link, List<String> tags) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.tags = tags;
    }

    public ToolsJpaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

