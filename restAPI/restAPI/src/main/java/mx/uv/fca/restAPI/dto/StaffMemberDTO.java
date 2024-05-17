package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("staff")
public class StaffMemberDTO {
    @NonNull
    @Size(max = 100)
    private String name;

    @NonNull
    private LocalDateTime joinDate;

    @NonNull
    private StaffTypes type;

    private String id;
}
