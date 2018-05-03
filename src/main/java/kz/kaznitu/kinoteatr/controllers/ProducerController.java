package kz.kaznitu.kinoteatr.controllers;

import kz.kaznitu.kinoteatr.models.Film;
import kz.kaznitu.kinoteatr.models.Producer;
import kz.kaznitu.kinoteatr.repositories.FilmRepository;
import kz.kaznitu.kinoteatr.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProducerController {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public String playersList(Model model){
        Producer prod = new Producer();
        model.addAttribute("prod",prod);
        model.addAttribute("producers", producerRepository.findAll());
        model.addAttribute("films", filmRepository.findAll());
        return "films";
    }

    @RequestMapping(value = "/addprod",method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute Producer prod) {
        producerRepository.save(prod);
        return "redirect:/films";
    }
}
