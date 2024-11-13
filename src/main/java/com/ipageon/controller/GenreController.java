package com.ipageon.controller;

import com.ipageon.entity.Genre;
import com.ipageon.repository.GenreRepository;
import io.micronaut.http.annotation.Controller;

@Controller
public class GenreController {
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void save(Genre genre) {
        this.genreRepository.save(genre);
    }

    public Genre findByName(String name) {
        return this.genreRepository.findByName(name);
    }
}
