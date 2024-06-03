package org.camoun.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

import org.camoun.quarkus.starting.entity.Book;
import org.camoun.quarkus.starting.repository.BookRepository;
import org.jboss.logging.Logger;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    public BookRepository bookRepository;

    @Inject
    Logger logger;


    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Returns the number of books");
        return getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("Returns a single book with id " + id);
        return bookRepository.getBookById(id);
    }
}
