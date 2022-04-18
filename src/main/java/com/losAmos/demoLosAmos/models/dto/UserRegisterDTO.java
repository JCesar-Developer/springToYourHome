package com.losAmos.demoLosAmos.models.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserRegisterDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String avatar;

    //Constructor without arguments
    public UserRegisterDTO() {
    }

    //Constructor with all arguments
    public UserRegisterDTO(Long id, String name, String surname, String email, String password, String avatar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }

    //Constructor with arguments without id
    public UserRegisterDTO(String name, String surname, String email, String password, String avatar) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }

    //Constructor only with email
    public UserRegisterDTO(String email) {
        this.email = email;
    }

    //Getters and Setters
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}