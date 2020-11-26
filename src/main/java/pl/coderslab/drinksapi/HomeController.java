package pl.coderslab.drinksapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.drinksapi.app.Drink;
import pl.coderslab.drinksapi.app.User;
import pl.coderslab.drinksapi.reposietories.DrinkRepository;
import pl.coderslab.drinksapi.reposietories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private UserRepository userRepository;
    private DrinkRepository drinkRepository;

    public HomeController(UserRepository userRepository, DrinkRepository drinkRepository) {
        this.userRepository = userRepository;
        this.drinkRepository = drinkRepository;
    }


    @RequestMapping("/")
    public String hello() {

        return "home";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";

    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registration";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "book/book";
        } else {

            userRepository.save(user);
        }


        return "login";
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, HttpServletRequest request) {




        model.addAttribute("user",request.getSession().getAttribute("loggedUser"));
        Object loggedUser = request.getSession().getAttribute("loggedUserId");

        List<Drink> byUserId = drinkRepository.findByUserId((Long) loggedUser);

        model.addAttribute("countDrinks",byUserId.size());





        return "logged/dashboard";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String email, @RequestParam String password, HttpServletRequest request) {


        User user = userRepository.findByEmailAndPassword(email,password);

        if(user!=null){


            request.getSession().setAttribute("loggedUser", user);
            request.getSession().setAttribute("loggedUserId", user.getId());


            return "redirect:dashboard";
        }

        return "login";

    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("drink", new Drink());
        return "logged/addDrink";

    }



}
