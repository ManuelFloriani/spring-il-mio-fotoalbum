package org.java.finalprove.photoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //NAME
    @NotBlank(message = "Name cannot be blank")
    private String name;

    //////////////// GETTERS AND SETTERS ////////////////
    //ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
