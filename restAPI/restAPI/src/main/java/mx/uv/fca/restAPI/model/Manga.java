package mx.uv.fca.restAPI.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("mangas")
public class Manga {
    @Id
    private ObjectId id;
    private LocalDateTime releaseDate;
    private String author;
    private String title;
}
