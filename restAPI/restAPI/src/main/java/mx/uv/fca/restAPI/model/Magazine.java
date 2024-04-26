package mx.uv.fca.restAPI.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("magazines")
public class Magazine {
    private List<Manga> releasedMangas;
    private LocalDateTime releaseDate;
    private String title;
    private String editorial;

    public List<Manga> getReleasedMangas() {
        return releasedMangas;
    }

    public void setReleasedMangas(List<Manga> releasedMangas) {
        this.releasedMangas = releasedMangas;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
