package org.camoun.quarkus.starting.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.camoun.quarkus.starting.entity.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "The Priory of the Orange Tree", "Samantha Shannon", 2019, genre),
                new Book(2, "Keeper of the Lost Cities", "Samantha Messenger", 2012, genre),
                new Book(3, "The Jasmine Throne", "Tasha Suri", 2021, genre),
                new Book(4, "The Warrior's Path", "Catherine M. Wilson", 2008, genre)
        );
    }

    public Optional<Book> getBookById(Integer id) {
        return getAllBooks().stream().filter(b -> b.getId() == id).findFirst();
    }
}
