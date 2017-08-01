package ua.ifntung.webstore.DAO;


import ua.ifntung.webstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ifntung.webstore.model.Order;

import javax.faces.bean.ManagedBean;
import java.time.LocalDateTime;
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

    @Autowired
    private OrderDAO orderDAO;

    private Order order;

    private List<Book> books;

    public List<Book> getBooks() {
        if (books == null){
            books = bookDAO.getBooks();
        }
        return books;
    }

    public Order getOrder() {
        return order;
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

    public void setUserInOrder(String username){
        this.order.setUsername(username);
    }

    public void setBookNameInOrder(String bookname){
        this.order.setBookname(bookname);
    }

    public void setphone(String phone){
        this.order.setPhone(phone);
    }

    public void setOrderDetails(String FName, String LName, String phone,String city){
        this.order.setFName(FName);
        this.order.setLName(LName);
        this.order.setPhone(phone);
        this.order.setCity(city);
        //this.order.setTime(LocalDateTime.now());
    }

    public void addOrder(){
        orderDAO.addOrder(order);
    }


}
