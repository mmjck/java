package com.bossabox.ms.core.domain.model;

import jakarta.persistence.*;

import java.util.List;


public class Tools {

    private Long id;
    private String title;
    private String description;
    private String link;
    private List<String> tags;

    public Tools(Long id, String title, String description, String link, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.tags = tags;
    }

    public Tools(String title, String description, String link, List<String> tags) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.tags = tags;
    }

    public Tools() {
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

