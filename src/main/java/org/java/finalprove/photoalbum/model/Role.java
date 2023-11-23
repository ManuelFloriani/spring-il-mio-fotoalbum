package org.java.finalprove.photoalbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private Integer id;

    private String name;

    ///////////// GETTERS AND SETTERS /////////////
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
