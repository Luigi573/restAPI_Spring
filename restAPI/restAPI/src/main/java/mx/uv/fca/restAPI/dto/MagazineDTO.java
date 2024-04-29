package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document("magazines")
public class MagazineDTO {
    @NonNull
    private List<MangaDTO> releasedMangas;

    @NonNull
    private LocalDateTime releaseDate;

    @NonNull
    @Size(min = 20, max = 100)
    private String title;

    @NonNull
    @Size(min = 20, max = 50)
    private String editorial;

    public List<MangaDTO> getReleasedMangas() {
        return releasedMangas;
    }

    public void setReleasedMangas(List<MangaDTO> releasedMangas) {
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
