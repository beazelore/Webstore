package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Павло on 14.07.2017.
 */
@Entity
public class Book implements Serializable{
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;

    @JoinColumn(name = "genre")
    private Genre genre;

    @JoinColumn(name = "author")
    private Author author;
    @Basic
    @Column(name = "pages")
    private Integer pages;
    @Basic
    @Column(name = "isbn")
    private String isbn;
    @Basic
    @Column(name = "year_of_publication")
    private Integer yearOfPublication;
    @Basic
    @Column(name = "price")
    private long price;
    @Basic
    @Column(name = "image")
    private String image;

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublcation) {
        this.yearOfPublication = yearOfPublcation;
    }


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
        if (yearOfPublication != null ? !yearOfPublication.equals(book.yearOfPublication) : book.yearOfPublication != null)
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
        result = 31 * result + (yearOfPublication != null ? yearOfPublication.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }
}
