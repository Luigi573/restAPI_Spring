package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("staff")
public class StaffMemberDTO {
    private ObjectId id;
    
    @NotBlank(message = "Nombre no definido")
    @Size(max = 100)
    private String name;

    private LocalDate joinDate;

    @NotNull(message = "Defina un tipo de miembro")
    private StaffTypes type;
}
