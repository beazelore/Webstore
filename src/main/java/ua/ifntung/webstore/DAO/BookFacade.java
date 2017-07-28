package ua.ifntung.webstore.DAO;


import ua.ifntung.webstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by Павло on 19.07.2017.
 */
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
        if (books == null){
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


    public  void searchBooksByName(){
        books = bookDAO.getBooks(searchCriteria.getText());
    }

}
