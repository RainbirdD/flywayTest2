package test1.flywayTesting.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.tables.book;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BooksRepo booksRepo;

    public List<book> all() {
        return (List<book>) booksRepo.findAll();
    }
}
