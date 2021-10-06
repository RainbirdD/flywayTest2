package test1.flywayTesting.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.services.BookService;

import static groovy.json.JsonOutput.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BooksControllerTest124 {

@Autowired
MockMvc mvc;
@MockBean
BookService bookService;

        @Test
        public void createBook() throws Exception {

                BookDTO bookDTO = new BookDTO();
                bookDTO.setTitle("t");
                bookDTO.setAuthor("A");

                mvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(bookDTO)))
                .andExpect(status().isBadRequest());
        }
}