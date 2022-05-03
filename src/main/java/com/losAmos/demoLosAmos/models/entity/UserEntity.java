package com.losAmos.demoLosAmos.models.entity;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserEntity implements Serializable {

    private static final long serialVersion = 1L;

    // ------------------ //
    // --- ATTRIBUTES --- //
    // ------------------ //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ingrese su nombre.")
    private String name;

    @NotBlank(message = "Ingrese su apellido.")
    private String surname;

    @Column(unique = true)
    @NotBlank(message = "Ingrese su email.")
    @Email(message = "Ingrese una dirección de email valida.")
    private String email;

    @Column(length = 20)
    @NotBlank(message = "Ingrese una contraseña.")
    @Length(min = 6, message = "La contraseña debe contener, como mínimo, 6 caracteres.")
    private String password;

    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "rol_id",referencedColumnName = "id"))
    private Collection<Role> roles;

    // ------------------- //
    // --- CONSTRUCTOR --- //
    // ------------------ //

    //DEFAULT CONSTRUCTOR
    public UserEntity() {
    }

    //CONSTRUCTOR WITH ARGUMENTS WITHOUT ID
    public UserEntity(String name, String surname, String email, String password, Collection<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    //CONSTRUC
    public UserEntity(String name, String surname, String email, String password, String avatar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles=" + roles +
                '}';
    }

}
