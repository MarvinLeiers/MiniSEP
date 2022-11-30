package sep.mini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sep.mini.model.Film;
import sep.mini.service.FilmService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class SEPRestController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/film/{id}")
    public Film getFilmById(@PathVariable long id) {
        return filmService.getFilmById(id);
    }

    @PostMapping("/film")
    public void addMovie(@RequestBody Film film) {
        filmService.addFilm(film);
    }

    @GetMapping("/search-film/{search}")
    public Film[] searchFilmsByAttributes(@PathVariable String search) {
        return filmService.findFilmsLike(search);
    }
}
