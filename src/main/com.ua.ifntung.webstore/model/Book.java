package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Павло on 14.07.2017.
 */
@Entity
public class Book {
    private long id;
    private String name;
    private Genre genre;
    private Author author;
    private Integer pages;
    private String isbn;
    private Integer yearOfPublcation;
    private long price;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "author")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Basic
    @Column(name = "pages")
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
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

    @Basic
    @Column(name = "price")
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (genre != book.genre) return false;
        if (author != book.author) return false;
        if (price != book.price) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (pages != null ? !pages.equals(book.pages) : book.pages != null) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (yearOfPublcation != null ? !yearOfPublcation.equals(book.yearOfPublcation) : book.yearOfPublcation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        //result = 31 * result + (int) (genre ^ (genre >>> 32));
        //result = 31 * result + (int) (author ^ (author >>> 32));
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (yearOfPublcation != null ? yearOfPublcation.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }
}
