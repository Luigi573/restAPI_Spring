package mx.uv.fca.restAPI.model;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("mangas")
public class Manga {
    private ObjectId _id;

    @NonNull
    private LocalDate releaseDate;

    @NonNull
    @Size(max = 50, message = "El título no debe exceder los 50 caracteres.")
    private String author;

    @NonNull
    @Size(min = 5, max = 100, message = "El tamaño del título debe estar entre 5 y 100 caracteres.")
    private String title;
}
