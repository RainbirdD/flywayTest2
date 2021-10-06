package test1.flywayTesting.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-06T13:42:03+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book dtoToEntity(BookDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( dto.getAuthor() );
        book.setTitle( dto.getTitle() );

        return book;
    }

    @Override
    public BookDTO entityToDto(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthor( entity.getAuthor() );
        bookDTO.setTitle( entity.getTitle() );

        return bookDTO;
    }

    @Override
    public List<BookDTO> entityListToDtoList(List<Book> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( entityList.size() );
        for ( Book book : entityList ) {
            list.add( entityToDto( book ) );
        }

        return list;
    }

    @Override
    public List<Book> dtoListToEntityList(List<BookDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( dtoList.size() );
        for ( BookDTO bookDTO : dtoList ) {
            list.add( dtoToEntity( bookDTO ) );
        }

        return list;
    }
}
