package org.java.finalprove.photoalbum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "photos")
public class Photo {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //TITLE
    @NotBlank(message = "title cannot be blank")
    @Size(min = 3, max = 50, message = "title must be between 3 and 50 characters")
    private String title;
    //DESCRIPTION
    @Lob
    @Size(min = 3, max = 500, message = "Description must be between 3 and 500 characters")
    private String description;
    //IMAGE URL
    @NotBlank(message = "Image URL cannot be blank")
    private String imageUrl;
    //VISIBILITY
    private Boolean visibility;

    ///////////////// RELATIONS /////////////////
    //CATEGORIES
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

    //////////////// GETTERS AND SETTERS ////////////////
    //ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //TITLE
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //DESCRIPTION
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //IMAGE URL
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    //VISIBILITY
    public Boolean getVisibility() {
        return visibility;
    }
    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    @JsonIgnore
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
