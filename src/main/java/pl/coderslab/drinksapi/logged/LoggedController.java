package pl.coderslab.drinksapi.logged;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.drinksapi.app.Drink;
import pl.coderslab.drinksapi.reposietories.DrinkRepository;
import pl.coderslab.drinksapi.users.AppUser;
import pl.coderslab.drinksapi.users.CurrentUser;
import pl.coderslab.drinksapi.users.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/logged")
public class LoggedController {


private DrinkRepository drinkRepository;
private UserRepository userRepository;

    public LoggedController(DrinkRepository drinkRepository, UserRepository userRepository) {
        this.drinkRepository = drinkRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, @AuthenticationPrincipal CurrentUser customUser) {

        AppUser entityUser = customUser.getAppUser();

        List<Drink> byUserId = drinkRepository.findByUserId(entityUser.getId());
        model.addAttribute("countDrinks",byUserId.size());


        return "logged/dashboard";
    }




    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("drink", new Drink());
        return "logged/addDrink";

    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String register(@Valid Drink drink, BindingResult result, @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()) {
            return "logged/addDrink";
        } else {

            LocalDateTime localDateTime = LocalDateTime.now();


            AppUser entityUser = customUser.getAppUser();
            drink.setCreated(localDateTime.toString());
            drink.setLikes(0);

            drink.setUser(entityUser);

        drinkRepository.save(drink);

        }

        return "redirect:/logged/drinks";
    }


    @RequestMapping(value = "/drinks", method = RequestMethod.GET)
    public String drinks(Model model, @AuthenticationPrincipal CurrentUser customUser) {

        AppUser entityUser = customUser.getAppUser();



        List<Drink> byUserId = drinkRepository.findByUserId(entityUser.getId());
        model.addAttribute("drinks",byUserId);


        return "logged/drinks";
    }
    @RequestMapping(value = "/drinks/{drinkId}", method = RequestMethod.GET)
    public String drinksDel(Model model, @AuthenticationPrincipal CurrentUser customUser,@PathVariable long drinkId) {

        AppUser entityUser = customUser.getAppUser();


        Drink byId = drinkRepository.findById(drinkId);

        drinkRepository.delete(byId);


        return "redirect:/logged/drinks";
    }


    @RequestMapping(value = "/editdrink/{drinkId}", method = RequestMethod.GET)
    public String editdrink(Model model, @AuthenticationPrincipal CurrentUser customUser,@PathVariable long drinkId) {



        Drink byId = drinkRepository.findById(drinkId);

        model.addAttribute("drink1",byId);
        model.addAttribute("drink", new Drink());



        return "logged/editDrink";
    }

    @RequestMapping(value = "/editdrink/{id}", method = RequestMethod.POST)
    public String editdrink(@Valid Drink drink, BindingResult result, @AuthenticationPrincipal CurrentUser customUser, @PathVariable long id, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "logged/addDrink";
        } else {

            Drink drink1 = drinkRepository.findById(id);
            drink.setPreparation(request.getParameter("preparation"));

            LocalDateTime localDateTime = LocalDateTime.now();
            AppUser entityUser = customUser.getAppUser();
            drink.setUser(entityUser);
            drink.setId(id);

            drink.setCreated(localDateTime.toString());


            drinkRepository.save(drink);

        }

        return "redirect:/logged/drinks";
    }


    @RequestMapping(value = "/edituser", method = RequestMethod.GET)
    public String editUser(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("userEdit", new AppUser());
        AppUser byUsername = userRepository.findByUsername(customUser.getUsername());
        model.addAttribute("user2",byUsername);
        return "logged/editUser";

    }
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String editUser(@Valid AppUser appUser, BindingResult result, @AuthenticationPrincipal CurrentUser customUser) {

        if (result.hasErrors()){
            return "logged/addDrink";
        } else {
        AppUser entityUser = customUser.getAppUser();
            appUser.setId(entityUser.getId());
            appUser.setPassword(entityUser.getPassword());

            userRepository.save(appUser);


        }

        return "redirect:/logged/dashboard";
    }






}
