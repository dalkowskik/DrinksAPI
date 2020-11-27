package pl.coderslab.drinksapi.users;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmailAndPassword(String email, String password);

    AppUser findByUsername(String username);

}
