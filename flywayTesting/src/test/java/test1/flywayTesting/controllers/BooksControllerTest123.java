package test1.flywayTesting.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.mappers.BookMapper;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.services.BookService;
import org.springframework.http.HttpStatus;

import static groovy.json.JsonOutput.toJson;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class BooksControllerTest123 {

    @Autowired
    private BookService bookService;

    @Autowired
    private BooksRepo booksRepo;

    private BookMapper bookMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestRestTemplate restTemplate;

    ObjectMapper om = new ObjectMapper();

    @Autowired
   private MockMvc mvc;


    @Test
    public void addBook() throws Exception {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor("Normal Author1");
        bookDTO.setTitle("Normal Title1");

        ResponseEntity<BookDTO> response = restTemplate.postForEntity("/books", bookDTO, BookDTO.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    public void  addWrongBookTestError() throws Exception{
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor("s");
        bookDTO.setTitle("q");

        ResponseEntity<BookDTO> response = restTemplate.postForEntity("/books", bookDTO, BookDTO.class);
        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void  addExistedBookTestError() throws Exception{
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor("Default Author");
        bookDTO.setTitle("Default Book");

        ResponseEntity<BookDTO> response = restTemplate.postForEntity("/books", bookDTO, BookDTO.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    }






    @Test
    public void mockTestForErrors() throws Exception{

//        ObjectNode book = om.createObjectNode();
        BookDTO book = new BookDTO();

        book.setAuthor("s");
        book.setTitle("s");

        String bookJson = om.writerWithDefaultPrettyPrinter().writeValueAsString(book);

        mvc.perform(
                post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
              .andExpect(MockMvcResultMatchers.jsonPath("$.author", Is.is("Author must have name")))
              .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is("Title must have > 2 letters")));

    }


}