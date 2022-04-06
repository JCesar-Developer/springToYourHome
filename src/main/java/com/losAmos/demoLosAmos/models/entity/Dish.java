package com.losAmos.demoLosAmos.models.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dishes")
public class Dish implements Serializable {

    // ----------------- //
    // --- ATRIBUTES --- //
    // ----------------- //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private Long    category;
    @Column(name="dish_label_one")
    private Long    dishLabelOne;
    @Column(name="dish_label_two")
    private Long    dishLabelTwo;
    @Column(name="dish_label_three")
    private Long    dishLabelThree;
    private String  description;
    private String  ingredients;
    private Float   price;
    private String  imagen;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
