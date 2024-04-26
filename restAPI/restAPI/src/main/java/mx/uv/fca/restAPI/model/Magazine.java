package mx.uv.fca.restAPI.model;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import jakarta.validation.constraints.Size;

@Document("magazines")
public class Magazine {
    private ObjectId _id;

    @NonNull
    private List<Manga> releasedMangas;

    @NonNull
    private LocalDateTime releaseDate;

    @NonNull
    @Size(min = 20, max = 100)
    private String title;

    @NonNull
    @Size(min = 20, max = 50)
    private String editorial;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

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
