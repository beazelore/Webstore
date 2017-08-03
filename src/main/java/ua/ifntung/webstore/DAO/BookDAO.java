package ua.ifntung.webstore.DAO;


import ua.ifntung.webstore.model.Author;
import ua.ifntung.webstore.model.Book;
import ua.ifntung.webstore.model.Genre;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    List<Book> getBooks(Author author);

    List<Book> getBooks(String bookName);

    List<Book> getBooks(Genre genre);

    void delete(Long id);

}

