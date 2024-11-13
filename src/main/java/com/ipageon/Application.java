package com.ipageon;

import com.ipageon.controller.GenreController;
import com.ipageon.entity.Genre;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = Micronaut.run(Application.class, args);
        GenreController genreController = applicationContext.getBean(GenreController.class);
        Genre genre = new Genre();
        genre.setName("One00");

        genreController.save(genre);
        System.err.println(genreController.findByName("One00"));
    }
}