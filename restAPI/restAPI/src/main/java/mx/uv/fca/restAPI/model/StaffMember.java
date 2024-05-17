package mx.uv.fca.restAPI.model;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("staff")
public class StaffMember {
    private ObjectId id;

    @NonNull
    @Size(max = 100)
    private String name;

    @NonNull
    private LocalDateTime joinDate;

    @NonNull
    private StaffTypes type;
}
