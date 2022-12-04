package sep.mini;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sep.mini.model.Film;
import sep.mini.service.FilmService;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FilmService filmService) {
		return args -> {
			filmService.addFilm(
					new Film(
							"Harry Potter und der Stein der Weisen",
							"J.K Rowling",
							234,
							2001
					),
					new Film(
							"Harry Potter und die Kammer des Schreckens",
							"J.K Rowling",
							234,
							2002
					),
					new Film(
							"Toller Film",
							"Marvin Leiers",
							234,
							2022
					)
			);
		};
	}
}
