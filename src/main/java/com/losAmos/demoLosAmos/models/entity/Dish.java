package com.losAmos.demoLosAmos.models.entity;


import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="dishes")
public class Dish implements Serializable {

    // ----------------- //
    // --- ATRIBUTES --- //
    // ----------------- //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    @NotBlank
    @Size(min=4, max=45)
    private String  name;

    @NotNull
    private Long    category;

    @NotNull
    @Column(name="dish_label_one")
    private Long    dishLabelOne;

    @Column(name="dish_label_two")
    private Long    dishLabelTwo;

    @Column(name="dish_label_three")
    private Long    dishLabelThree;

    @NotBlank
    private String  description;

    @NotBlank
    private String  ingredients;

    @NotNull
    private Float   price;

    private String  image;

    private Boolean available;

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

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getDishLabelOne() {
        return dishLabelOne;
    }

    public void setDishLabelOne(Long dishLabelOne) {
        this.dishLabelOne = dishLabelOne;
    }

    public Long getDishLabelTwo() {
        return dishLabelTwo;
    }

    public void setDishLabelTwo(Long dishLabelTwo) {
        this.dishLabelTwo = dishLabelTwo;
    }

    public Long getDishLabelThree() {
        return dishLabelThree;
    }

    public void setDishLabelThree(Long dishLabelThree) {
        this.dishLabelThree = dishLabelThree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    // --------------------- //
    // --- CLASS METHODS --- //
    // --------------------- //
    //¿Why is it important serialize our entities? -> Look on the documentation.
    private static final long serialVersionUID = 1L;
}
