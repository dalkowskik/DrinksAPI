package pl.coderslab.drinksapi.reposietories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.drinksapi.app.Drink;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink,Long> {

    @Query("select * from drinks where user_id=?1")
    public List<Drink> findByUserId(long adminId);

    Drink findById(long id);

}
