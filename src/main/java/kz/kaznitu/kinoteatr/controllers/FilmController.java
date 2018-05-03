package kz.kaznitu.kinoteatr.controllers;

import kz.kaznitu.kinoteatr.models.Film;
import kz.kaznitu.kinoteatr.models.Producer;
import kz.kaznitu.kinoteatr.repositories.FilmRepository;
import kz.kaznitu.kinoteatr.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ProducerRepository producerRepository;


    @RequestMapping(value = "/addkino",method = RequestMethod.POST)
    public String addPlayer(@RequestParam Long prodIId,
                            @RequestParam String fullName,
                            @RequestParam String genre,
                            Model model) {
        Producer prod = producerRepository.findById(prodIId).get();
        Film film = new Film();
        film.setFullName(fullName);
        film.setGenre(genre);
        film.setProducer(prod);
        filmRepository.save(film);

        return "redirect:/films";
    }
}
