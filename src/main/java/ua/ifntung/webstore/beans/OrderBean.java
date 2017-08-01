package ua.ifntung.webstore.beans;

import org.springframework.context.annotation.Scope;

import javax.faces.bean.ManagedBean;

/**
 * Created by Павло on 31.07.2017.
 */
@ManagedBean
@Scope("singleton")
public class OrderBean {

    private String username;
    private String bookname;

    public OrderBean() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

}
