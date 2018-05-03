package kz.kaznitu.kinoteatr.controllers;

import kz.kaznitu.kinoteatr.models.User;
import kz.kaznitu.kinoteatr.repositories.FilmRepository;
import kz.kaznitu.kinoteatr.repositories.ProducerRepository;
import kz.kaznitu.kinoteatr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public String home(Model model){
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("films",filmRepository.findAll());
        model.addAttribute("producers",producerRepository.findAll());
        return "home";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
            userService.saveUser(user);
            modelAndView.setViewName("home");
        return modelAndView;
    }

}
