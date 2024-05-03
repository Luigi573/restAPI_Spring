package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
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
}
