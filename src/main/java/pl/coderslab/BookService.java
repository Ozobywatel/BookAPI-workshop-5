package pl.coderslab;

import java.util.ArrayList;
import java.util.List;

public interface BookService {

        List<Book> getBooks();

    void add(Book book);

}