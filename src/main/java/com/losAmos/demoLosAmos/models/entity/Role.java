package com.losAmos.demoLosAmos.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersion = 1L;

    // ------------------ //
    // --- ATTRIBUTES --- //
    // ------------------ //
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;


    // Constructor
    public Role() {
    }

    // Constructor only with name
    public Role(String name) {
        this.name = name;
    }

    // Constructor with arguments
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // ------------------------- //
    // --- GETTERS & SETTERS --- //
    // ------------------------- //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
