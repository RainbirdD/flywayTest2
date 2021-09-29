package test1.flywayTesting.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test1.flywayTesting.mappers.bookMapper;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BooksRepo booksRepo;
    private final bookMapper mapper;



    public List<BookDTO> all() {
        List<Book> booksEntityList = (List<Book>) booksRepo.findAll();
        List<BookDTO> bookDTOList = mapper.entityListToDtoList(booksEntityList);
        return bookDTOList;
//        return (List<Book>) booksRepo.findAll();
    }


    public Book addBook(Book book) {
        return booksRepo.save(book);
    }



}
