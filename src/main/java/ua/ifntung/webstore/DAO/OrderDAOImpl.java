package ua.ifntung.webstore.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.ifntung.webstore.model.Order;

/**
 * Created by Павло on 30.07.2017.
 */
@Component
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    private Session session;

    @Override
    @Transactional
    public void addOrder(Order order) {
   /*     session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();*/
    }

}
