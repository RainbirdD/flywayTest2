package test1.flywayTesting.tables;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class book {

    @Id
    private int id;
    private String author;
    private String title;

}