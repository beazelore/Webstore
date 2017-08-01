package ua.ifntung.webstore.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.ifntung.webstore.hibernate.HibernateUtil;

import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Created by Павло on 14.07.2017.
 */
@Entity(name = "orders")
@ManagedBean
public class Order {

   // @SequenceGenerator(name = "myseqger", sequenceName = "order_id_seq", schema = "publc")
   /* @GenericGenerator(name = "myseqger",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "force_table_use", value = "1"),
            @org.hibernate.annotations.Parameter(name = "value_column", value = "id"),
            @org.hibernate.annotations.Parameter(name = "sequence", value = "order_id_seq"),

    }
    )*/
   /* @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @Column(name = "id")*/
    private Long id;

    private String username;

    private String bookname;

    private String FName;

    private String LName;

    private String city;

    private String phone;
    private Timestamp time;

    //private Order order;

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

    public void setUser(){
        this.username= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden1");
    }
    public void setBook(){
        this.bookname= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden2");
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
       // this.order.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
        //this.order.bookname = bookname;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
        //this.order.FName = FName;

    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
        //this.order.LName = LName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        //this.order.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
       // this.order.phone = phone;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setDate(){
        this.time = Timestamp.valueOf(LocalDateTime.now());
    }

   @Transactional
    public void add(){

        //setBookname(orderBean.getBookname());
        setBook();
        setUser();
        setDate();
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
        session.close();
    }

    public void outcome(){
        System.out.println("woooh!!!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (username != null ? !username.equals(order.username) : order.username != null) return false;
        if (bookname != null ? !bookname.equals(order.bookname) : order.bookname != null) return false;
        if (FName != null ? !FName.equals(order.FName) : order.FName != null) return false;
        if (LName != null ? !LName.equals(order.LName) : order.LName != null) return false;
        if (city != null ? !city.equals(order.city) : order.city != null) return false;
        if (phone != null ? !phone.equals(order.phone) : order.phone != null) return false;
        return time != null ? time.equals(order.time) : order.time == null;
    }

}
