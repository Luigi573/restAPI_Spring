package mx.uv.fca.restAPI.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("mangas")
public class MangaDTO {
    @NonNull
    private LocalDate releaseDate;

    @NonNull
    @Size(max = 50)
    private String author;

    @NonNull
    @Size(min = 10, max = 100)
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
