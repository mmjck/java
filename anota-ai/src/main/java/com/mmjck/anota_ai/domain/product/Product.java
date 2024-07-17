package com.mmjck.anota_ai.domain.product;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mmjck.anota_ai.domain.product.dto.ProductDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String ownerId;
    private String description;
    private Integer price;
    
    private String categoryId;

    public Product(ProductDTO dto){
        this.title = dto.title();
        this.description = dto.description();
        this.ownerId = dto.ownerId();
        this.price = dto.price();
        this.categoryId = dto.categoryId();
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();

        json.put("id", this.id);
        json.put("ownerId", this.ownerId);
        json.put("title", this.title);
        json.put("price", this.price);
        
        json.put("categoryId", this.categoryId);
        
        return json.toString();
    }
    
}
