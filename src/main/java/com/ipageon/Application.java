package com.ipageon;

import com.ipageon.controller.GenreController;
import com.ipageon.entity.Genre;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Inject;

public class Application {
    public static void main(String[] args){
        ApplicationContext applicationContext = Micronaut.run(Application.class, args);
        GenreController genreController = applicationContext.getBean(GenreController.class);


        Genre genre = new Genre();
//        genre.setId(7L);
//        genre.setName("wow");
////
//        genreController.save(genre);
        System.err.println(genreController.findByName("wow"));
    }
}