package sep.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sep.mini.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT f FROM Film AS f WHERE UPPER(f.title) LIKE CONCAT('%', UPPER(:search), '%') OR UPPER(f.author) LIKE CONCAT('%', UPPER(:search), '%')")
    Film[] findFilmsLike(@Param("search") String search);
}
