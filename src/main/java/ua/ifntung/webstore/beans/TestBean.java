package ua.ifntung.webstore.beans;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Павло on 15.07.2017.
 */
@Component
public class TestBean {
    @Autowired
    private SessionFactory sessionFactory;
    public void test(){
        System.out.println("sessionFactory = " + sessionFactory );
    }
}
