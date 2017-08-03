package ua.ifntung.webstore.objects;


import ua.ifntung.webstore.model.Genre;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@Component
@Scope("singleton")
@ManagedBean
public class Search implements Serializable {

    private String text;

    private Genre genre;

    private Long id;

    public Search() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
