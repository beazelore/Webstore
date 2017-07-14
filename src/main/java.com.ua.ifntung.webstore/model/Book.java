package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Павло on 14.07.2017.
 */
@Entity
public class Book {
    private long id;
    private String name;
    private long genre_id;
    private long author_id;
    private int pages;
    private String ISBN;
    private int year_of_publication;
    private BigDecimal price;
    private long genreId;
    private long authorId;
    private String isbn;
    private Integer yearOfPublcation;

    public Book() {
    }

    public Book(long id, String name, long genre_id, long author_id, int pages, String ISBN, int year_of_publication, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.pages = pages;
        this.ISBN = ISBN;
        this.year_of_publication = year_of_publication;
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Basic
    @Column(name = "pages")
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (genre_id != book.genre_id) return false;
        if (author_id != book.author_id) return false;
        if (pages != book.pages) return false;
        if (year_of_publication != book.year_of_publication) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (ISBN != null ? !ISBN.equals(book.ISBN) : book.ISBN != null) return false;
        return price != null ? price.equals(book.price) : book.price == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + genre_id;
        result = 31 * result + author_id;
        result = 31 * result + pages;
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0);
        result = 31 * result + year_of_publication;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "genre_id")
    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "author_id")
    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "year_of_publcation")
    public Integer getYearOfPublcation() {
        return yearOfPublcation;
    }

    public void setYearOfPublcation(Integer yearOfPublcation) {
        this.yearOfPublcation = yearOfPublcation;
    }
}
