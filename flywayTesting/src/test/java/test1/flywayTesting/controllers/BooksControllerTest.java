package test1.flywayTesting.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.services.BookService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class BooksControllerTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BooksRepo booksRepo;

    private test1.flywayTesting.mappers.bookMapper bookMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestRestTemplate restTemplate;

    ObjectMapper om = new ObjectMapper();

    @Test
    public void addBook() throws Exception {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor("Some");
        bookDTO.setTitle("Book");

        ResponseEntity<BookDTO> response = restTemplate.postForEntity("/books", bookDTO, BookDTO.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));

    }
}