package test1.flywayTesting.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import test1.flywayTesting.entities.BookDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BooksControllerDublicateTest {

@Autowired
MockMvc mvc;


        @Test
        public void createBook() throws Exception {

                BookDTO bookDTO = new BookDTO();
                bookDTO.setAuthor("Yakub Zwiek");
                bookDTO.setTitle("Klamca");

                mvc.perform(
                                post("/books")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(String.valueOf(bookDTO))
                        )
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isBadRequest());

        }
}