package mx.uv.fca.restAPI.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document("mangas")
public class MangaDTO {
    private ObjectId _id;

    @NonNull
    private LocalDate releaseDate;

    @NonNull
    @Size(max = 50)
    private String author;

    @NonNull
    @Size(min = 10, max = 100)
    private String title;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
