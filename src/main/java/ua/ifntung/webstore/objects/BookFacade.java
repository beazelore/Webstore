package ua.ifntung.webstore.objects;


import ua.ifntung.webstore.DAO.BookDAO;
import ua.ifntung.webstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component("bookFacade")
@ManagedBean
@Scope("singleton")
public class BookFacade {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private Search searchCriteria;

    private List<Book> books;

    public List<Book> getBooks() {
        if (books == null) {
            books = bookDAO.getBooks();
        }
        return books;
    }

    public void getAll() {
        books = bookDAO.getBooks();
    }

    public void searchBooksByGenre() {
        books = bookDAO.getBooks(searchCriteria.getGenre());
    }


    public void searchBooksByName() {
        books = bookDAO.getBooks(searchCriteria.getText());
    }

    public void deleteBook() {
        bookDAO.delete(searchCriteria.getId());
    }


}
