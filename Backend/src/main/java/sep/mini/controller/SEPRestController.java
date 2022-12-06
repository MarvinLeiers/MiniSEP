package sep.mini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep.mini.model.Film;
import sep.mini.service.FilmService;
import sep.mini.util.StringResponse;

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

    @DeleteMapping("/film/{id}")
    public void deleteFilmById(@PathVariable long id) {
        filmService.deleteFilmById(id);
    }

    @GetMapping("/film")
    public Film[] getFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping("/film")
    public ResponseEntity<StringResponse> addMovie(@RequestBody Film film) {
        if (filmService.findMovieByTitle(film.getTitle()) != null) {
            return ResponseEntity
                    .status(HttpStatus.ALREADY_REPORTED)
                    .body(new StringResponse("Film already exists"));
        }

        filmService.addFilm(film);

        return ResponseEntity
                .ok()
                .body(new StringResponse("test"));
    }

    @GetMapping("/search-film/{search}")
    public Film[] searchFilmsByAttributes(@PathVariable String search) {
        return filmService.findFilmsLike(search);
    }
}
