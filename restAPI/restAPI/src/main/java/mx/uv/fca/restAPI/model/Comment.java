package mx.uv.fca.restAPI.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("comments")
public class Comment {
    private ObjectId _id;

    @NonNull
    private Chapter chapter;

    @NonNull
    private LocalDateTime postDate;

    @NonNull
    @Size(min = 10)
    private String commenter;

    @NonNull
    @Size(max = 300)
    private String content;
}