package mx.uv.fca.restAPI.model;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("mangas")
public class Manga {
    private LocalDate releaseDate;
    private String author;
    private String genre;
    private String title;

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
