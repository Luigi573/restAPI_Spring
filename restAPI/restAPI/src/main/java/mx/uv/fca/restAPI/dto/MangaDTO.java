package mx.uv.fca.restAPI.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("mangas")
public class MangaDTO {
    @NonNull
    private LocalDateTime releaseDate;

    @NotBlank(message = "Autor no definido")
    @Size(max = 50, message = "El título no debe exceder los 50 caracteres.")
    private String author;

    @NotBlank(message = "Título no definido")
    @Size(min = 5, max = 100, message = "El tamaño del título debe estar entre 5 y 100 caracteres.")
    private String title;

    private String id;
}
