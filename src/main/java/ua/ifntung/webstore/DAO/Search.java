package ua.ifntung.webstore.DAO;


import ua.ifntung.webstore.model.Genre;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 * Created by Павло on 20.07.2017.
 */
@Component
@Scope("singleton")
@ManagedBean
public class Search implements Serializable {

    private String text;

    private Genre genre;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
