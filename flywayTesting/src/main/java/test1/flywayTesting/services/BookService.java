package test1.flywayTesting.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import test1.flywayTesting.exceptions.BookAlreadyExistException;
import test1.flywayTesting.mappers.BookMapper;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BooksRepo booksRepo;
    private final BookMapper mapper;

    public List<BookDTO> all() {
        List<Book> booksEntityList = booksRepo.findAll();
        List<BookDTO> bookDTOList = mapper.entityListToDtoList(booksEntityList);
        return bookDTOList;
    }

    public boolean isExistByAuthorAndTitle(Book book) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");
        Example<Book> bookExample = Example.of(book, exampleMatcher);

        return booksRepo.exists(bookExample);
    }

    public void createBook(BookDTO bookDTO) throws Exception {

        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());

        if (isExistByAuthorAndTitle(book)) {
            throw new BookAlreadyExistException("The book " + " already exist");
        } else {
            Book savedBook = booksRepo.save(book);
            BookDTO bookResponse = new BookDTO();
            bookResponse.setAuthor(savedBook.getAuthor());
            bookResponse.setTitle(savedBook.getTitle());
        }
    }


}
