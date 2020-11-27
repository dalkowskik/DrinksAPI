package pl.coderslab.drinksapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.drinksapi.users.*;

import pl.coderslab.drinksapi.reposietories.DrinkRepository;

import javax.validation.Valid;

@Controller
public class HomeController {

    private UserRepository userRepository;
    private DrinkRepository drinkRepository;
    private RoleRepository roleRepository;
    private UserService userService;

    public HomeController(UserRepository userRepository, DrinkRepository drinkRepository, RoleRepository roleRepository, UserService userService) {
        this.userRepository = userRepository;
        this.drinkRepository = drinkRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    //
//    public HomeController(UserRepository userRepository, DrinkRepository drinkRepository) {
//        this.userRepository = userRepository;
//        this.drinkRepository = drinkRepository;
//    }
//
//
//    @RequestMapping("/")
//    public String hello() {
//
//        return "home";
//
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//
//        return "login";
//
//    }
//
//
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new AppUser());
        return "registration";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid AppUser user, BindingResult result) {

        if (result.hasErrors()) {
            return "registration";
        } else {



            userService.saveUser(user);
        }


        return "login";
    }

//
//
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(Model model, @RequestParam String email, @RequestParam String password, HttpServletRequest request) {
//
//
//        AppUser user = userRepository.findByEmailAndPassword(email,password);
//
//        if(user!=null){
//
//
//            request.getSession().setAttribute("loggedUser", user);
//            request.getSession().setAttribute("loggedUserId", user.getId());
//
//
//            return "redirect:logged/dashboard";
//        }
//
//        return "login";
//
//    }






}
