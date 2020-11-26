package pl.coderslab.drinksapi.app;

import javax.persistence.*;

@Entity
@Table(name = "coments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;

    @ManyToOne
    private Drink drink;

    @ManyToOne
    private User user;

}
