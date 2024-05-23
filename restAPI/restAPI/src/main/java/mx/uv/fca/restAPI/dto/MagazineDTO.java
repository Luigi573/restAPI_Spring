package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Título no definido")
    @Size(min = 20, max = 100, message = "El título debe tener entre 20-100 caracteres")
    private String title;

    @NotBlank(message = "Editorial no definida")
    @Size(min = 5, max = 50, message = "Editorial debe tener entre 5-50 caracteres")
    private String editorial;

    private String id;
}
