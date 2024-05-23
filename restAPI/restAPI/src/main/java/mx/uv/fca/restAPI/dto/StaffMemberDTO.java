package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document("staff")
public class StaffMemberDTO {
    @NotBlank(message = "Nombre no definido")
    @Size(max = 100)
    private String name;

    @NonNull
    private LocalDate joinDate;

    @NonNull
    private StaffTypes type;

    private String id;
}
