package DAO;

import model.Author;
import model.Book;
import model.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Павло on 17.07.2017.
 */
@Component
public class BookDAOImpl  implements BookDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books;

    private ProjectionList bookProection;

    public BookDAOImpl(){
        bookProection = Projections.projectionList();
        bookProection.add(Projections.property("id"),"id");
        bookProection.add(Projections.property("name"),"name");
        bookProection.add(Projections.property("genre"),"genre");
        bookProection.add(Projections.property("author"),"author");
        bookProection.add(Projections.property("pages"),"pages");
        bookProection.add(Projections.property("isbn"),"isbn");
        bookProection.add(Projections.property("yearOfPublication"),"yearOfPublication");
        bookProection.add(Projections.property("price"),"price");

    }

    @Transactional
    @Override
    public  List<Book> getBooks() {

        books = (List<Book>) sessionFactory.openSession().createCriteria(Book.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return books;
    }
    /*public void test(){
        System.out.println(books.get(1));
    }*/

    @Override
    public List<Book> getBooks(Author author) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("authorName",author.getName(),MatchMode.ANYWHERE)));
        return books;
    }

    @Override
    public List<Book> getBooks(String bookName) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("b.name", bookName ,MatchMode.ANYWHERE)));
        return books;
    }

    @Override
    public List<Book> getBooks(Genre genre) {
        List<Book> books = createBookList(createBookCriteria().add(Restrictions.ilike("genreName",genre.getName(),MatchMode.ANYWHERE)));
        return books;
    }

    private DetachedCriteria createBookCriteria(){
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
}
