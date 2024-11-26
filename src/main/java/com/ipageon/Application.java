package com.ipageon;

import com.ipageon.controller.GenreController;
import com.ipageon.entity.Genre;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;
import jakarta.persistence.Entity;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = Micronaut.run(Application.class, args);
        GenreController genreController = applicationContext.getBean(GenreController.class);

        String name = "Start";
        Scanner scanner = new Scanner(System.in);
        System.out.print("name : ");
        name = scanner.nextLine();

        Genre genre = new Genre();
        genre.setName(name);
        genreController.save(genre);

        System.out.println("find...");
        System.out.println("result : " + genreController.findByName(name));
    }
}