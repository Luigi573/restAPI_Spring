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
@Document("comments")
public class Comment {
    @Id
    private ObjectId _id;
    private Chapter chapter;
    private LocalDateTime postDate;
    private String commenter;
    private String content;
}