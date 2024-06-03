package org.camoun.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
            .header(ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/books")
        .then()
            .statusCode(200)
            .body("size()", is(4));
    }

    @Test
    void shouldCountAllBooks() {
        given()
            .header(ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .get("/api/books/count")
        .then()
            .statusCode(200)
            .body(is("4"));
    }

    @Test
    void shouldGetABook() {
        given()
            .header(ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(200)
            .body("title", is("The Priory of the Orange Tree"))
                .body("author", is("Samantha Shannon"))
                .body("genre", is("Fantasy"))
                .body("yearOfPublication", is(2019));
    }

}