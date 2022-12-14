package sep.mini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sep.mini.model.Film;
import sep.mini.repository.FilmRepository;

import java.util.Arrays;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film getFilmById(long id) {
        return filmRepository
                .findById(id)
                .orElse(Film.INVALID);
    }

    public void addFilm(Film... films) {
        filmRepository.saveAll(Arrays.asList(films));

        for (Film film : films) // Print added films to console for testing purposes.
            System.out.println(film);
    }

    public Film[] findFilmsLike(String search) {
        return filmRepository.findFilmsLike(search);
    }

    public Film[] getAllFilms() {
        return filmRepository.findAll().toArray(new Film[]{});
    }

    public void deleteFilmById(long id) {
        filmRepository.deleteById(id);
    }

    public Film findMovieByTitle(String title) {
        return filmRepository.findFilmByTitle(title);
    }
}
