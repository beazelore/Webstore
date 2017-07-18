package DAO;

import model.Author;
import model.Book;
import model.Genre;

import java.util.List;

/**
 * Created by Павло on 15.07.2017.
 */
public interface BookDAO {
    List<Book> getBooks();

    List<Book> getBooks(Author author);

    List<Book> getBooks(String bookName);

    List<Book> getBooks(Genre genre);

}

