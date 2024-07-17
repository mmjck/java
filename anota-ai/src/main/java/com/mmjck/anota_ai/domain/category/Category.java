package com.mmjck.anota_ai.domain.category;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mmjck.anota_ai.domain.category.dto.CategoryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    private String id;
    private String title;
    private String ownerId;
    private String description;

    public Category(CategoryDTO dto){
        this.title = dto.title();
        this.description = dto.description();
        this.ownerId = dto.ownerId();
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();

        json.put("id", this.id);
        json.put("ownerId", this.ownerId);
        json.put("title", this.title);
        json.put("description", this.description);
        
        
        return json.toString();
    }

}
