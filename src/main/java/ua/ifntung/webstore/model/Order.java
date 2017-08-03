package ua.ifntung.webstore.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.ifntung.webstore.hibernate.HibernateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "orders")
@ManagedBean
public class Order {

    private Long id;

    private String username;

    private String bookname;

    private String FName;

    private String LName;

    private String city;

    private String phone;

    private Timestamp time;

    @Autowired
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private Session session;

    public Order() {

    }

    public Order(String username, String bookname, String FName, String LName, String city, String phone, Timestamp time) {
        this.username = username;
        this.bookname = bookname;
        this.FName = FName;
        this.LName = LName;
        this.city = city;
        this.phone = phone;
        this.time = time;
    }

    public void setUser() {
        this.username = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden1");
    }

    public void setBook() {
        this.bookname = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden2");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;

    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setDate() {
        this.time = Timestamp.valueOf(LocalDateTime.now());
    }

    @Transactional
    public void add() {

        setBook();
        setUser();
        setDate();
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
        session.close();
    }

    public void outcome() {
        System.out.println("woooh!!!");
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (FName != null ? FName.hashCode() : 0);
        result = 31 * result + (LName != null ? LName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (sessionFactory != null ? sessionFactory.hashCode() : 0);
        result = 31 * result + (session != null ? session.hashCode() : 0);
        return result;
    }
}
