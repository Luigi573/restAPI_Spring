package mx.uv.fca.restAPI.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("magazines")
public class Magazine {
    private ObjectId _id;

    @NotBlank
    private List<Manga> releasedMangas;

    @NotBlank
    private LocalDateTime releaseDate;

    @NotBlank
    @Size(min = 20, max = 100)
    private String title;

    @NotBlank
    @Size(min = 20, max = 50)
    private String editorial;
}
