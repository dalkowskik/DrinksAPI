package pl.coderslab.drinksapi.app;


import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String nick;
    @NotNull
    private String name;
    @NotNull
    private String surName;
    @NotNull
    private String email;
    @NotNull
    private String password;


    @OneToMany
    private List<Drink> drink;


    public User() {
    }

    public User(long id, @NotNull String nick, @NotNull String name, @NotNull String surName, @NotNull @Email String email, List<Drink> drink) {
        this.id = id;
        this.nick = nick;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.drink = drink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Drink> getDrink() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
