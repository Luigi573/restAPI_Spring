package mx.uv.fca.restAPI.model;

import java.util.Dictionary;
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
@Document("chapters")
public class Chapter {
    @Id
    private ObjectId _id;
    private float number;
    private String title;
    private List<StaffMember> staff;
    private ObjectId mangaId;
}
