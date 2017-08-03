package ua.ifntung.webstore.beans;

import org.springframework.context.annotation.Scope;

import javax.faces.bean.ManagedBean;

@ManagedBean
@Scope("singleton")
public class OrderBean {

    private String bookname;

    public OrderBean() {

    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

}
