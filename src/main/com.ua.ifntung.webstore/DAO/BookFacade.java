package DAO;

import DAO.BookDAO;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

/**
 * Created by Павло on 19.07.2017.
 */
@Component
public class BookFacade {
    private BookDAO bookDAO;
    @Autowired
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    private List<Book> books;

    public List<Book> getBooks(){

        return books;

    }
}
