package mx.uv.fca.restAPI.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("magazines")
public class Magazine {
    @Id
    private ObjectId _id;
    private List<Manga> releasedMangas;
    private LocalDateTime releaseDate;
    private String title;
    private String editorial;
}
