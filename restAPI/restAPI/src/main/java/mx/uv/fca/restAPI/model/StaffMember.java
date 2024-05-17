package mx.uv.fca.restAPI.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("staff")
public class StaffMember {
    @Id
    private ObjectId _id;
    private String name;
    private LocalDate joinDate;
    private StaffTypes type;
}
