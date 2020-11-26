package pl.coderslab.drinksapi.reposietories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.drinksapi.app.User;

public interface UserRepository extends JpaRepository<User,Long> {

public User findByEmailAndPassword(String email, String password);

}
