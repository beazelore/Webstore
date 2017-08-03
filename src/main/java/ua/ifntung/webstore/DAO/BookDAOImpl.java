package ua.ifntung.webstore.DAO;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;
import ua.ifntung.webstore.hibernate.HibernateUtil;
import ua.ifntung.webstore.model.Author;
import ua.ifntung.webstore.model.Book;
import ua.ifntung.webstore.model.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private ProjectionList bookProection;

    public BookDAOImpl() {
        bookProection = Projections.projectionList();
        bookProection.add(Projections.property("id"), "id");
        bookProection.add(Projections.property("name"), "name");
        bookProection.add(Projections.property("genre"), "genre");
        bookProection.add(Projections.property("author"), "author");
        bookProection.add(Projections.property("pages"), "pages");
        bookProection.add(Projections.property("isbn"), "isbn");
        bookProection.add(Projections.property("yearOfPublication"), "yearOfPublication");
        bookProection.add(Projections.property("price"), "price");
        bookProection.add(Projections.property("image"), "image");
    }

    @Transactional
    @Override
    public List<Book> getBooks() {

        List<Book> books = createBookList(createBookCriteria());
        return books;
    }

    @Override
    public List<Book> getBooks(Author author) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("authorName", author.getName(), MatchMode.ANYWHERE)));
        return books;
    }

    @Override
    @Transactional
    public List<Book> getBooks(String bookName) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("b.name", bookName, MatchMode.ANYWHERE)));
        return books;
    }

    @Transactional
    @Override
    public List<Book> getBooks(Genre genre) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.eq("genre.id", genre.getId())));
        return books;
    }

    private DetachedCriteria createBookCriteria() {
        DetachedCriteria bookListCriteria = DetachedCriteria.forClass(Book.class, "b");
        createAliases(bookListCriteria);
        return bookListCriteria;
    }


    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("b.author", "author");
        criteria.createAlias("b.genre", "genre");

    }

    private List<Book> createBookList(DetachedCriteria bookListCriteria) {
        Criteria criteria = bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProection).setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Session session;
        Book book;

        session = sessionFactory.openSession();
        book = session.load(Book.class, id);
        session.delete(book);

        session.flush();
        session.close();
        RequestContext.getCurrentInstance().update("booksList_content");

    }

}
