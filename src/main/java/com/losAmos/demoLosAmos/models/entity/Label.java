package com.losAmos.demoLosAmos.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="labels")
public class Label implements Serializable {
    // ----------------- //
    // --- ATRIBUTES --- //
    // ----------------- //
    @Id
    private Long id;

    @NotBlank
    private String name;

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
