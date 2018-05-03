package kz.kaznitu.kinoteatr.repositories;

import kz.kaznitu.kinoteatr.models.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film,Long> {
}
