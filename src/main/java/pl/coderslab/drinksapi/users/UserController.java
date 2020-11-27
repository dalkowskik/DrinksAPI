package pl.coderslab.drinksapi.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        AppUser user = new AppUser();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("admin@admin.pl");
        user.setNick("admin");
        user.setSurName("2");
        userService.saveUser(user);
        return "admin";
    }

}
