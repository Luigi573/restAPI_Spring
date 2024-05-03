package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Min;
import java.util.Dictionary;
import lombok.Data;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("chapters")
public class ChapterDTO {
    @Min(value = 1, message = "El capítulo debe ser un número mayor a 1")
    private float number;
    private String title;
    private Dictionary<StaffMemberDTO, StaffTypes> staff;
}
