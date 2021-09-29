package test1.flywayTesting.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import test1.flywayTesting.tables.book;
import test1.flywayTesting.tables.bookDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T12:07:03+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class bookMapperImpl implements bookMapper {

    @Override
    public book dtoToEntity(bookDTO dto) {
        if ( dto == null ) {
            return null;
        }

        book book = new book();

        book.setAuthor( dto.getAuthor() );
        book.setTitle( dto.getTitle() );

        return book;
    }

    @Override
    public bookDTO entityToDto(book entity) {
        if ( entity == null ) {
            return null;
        }

        bookDTO bookDTO = new bookDTO();

        bookDTO.setAuthor( entity.getAuthor() );
        bookDTO.setTitle( entity.getTitle() );

        return bookDTO;
    }

    @Override
    public List<bookDTO> entityListToDtoList(List<book> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<bookDTO> list = new ArrayList<bookDTO>( entityList.size() );
        for ( book book : entityList ) {
            list.add( entityToDto( book ) );
        }

        return list;
    }

    @Override
    public List<book> dtoListToEntityList(List<bookDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<book> list = new ArrayList<book>( dtoList.size() );
        for ( bookDTO bookDTO : dtoList ) {
            list.add( dtoToEntity( bookDTO ) );
        }

        return list;
    }
}
