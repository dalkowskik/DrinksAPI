package pl.coderslab.drinksapi.users;

public interface UserService {

    AppUser findByUserName(String name);


    void saveUser(AppUser appUser);
}
