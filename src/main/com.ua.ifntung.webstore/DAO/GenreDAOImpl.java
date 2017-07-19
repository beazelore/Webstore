package DAO;

import model.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Павло on 18.07.2017.
 */
@Component
public class GenreDAOImpl implements GenreDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Genre> getGenres() {
        return sessionFactory.openSession().createCriteria(Genre.class).list();
    }
}
