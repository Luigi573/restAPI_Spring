package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Dictionary;
import lombok.Data;
import mx.uv.fca.restAPI.model.StaffMember;
import mx.uv.fca.restAPI.model.StaffTypes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("chapters")
public class ChapterDTO {
    @Min(value = 1, message = "El capítulo debe ser un número mayor a 1")
    private float number;
    @NotBlank
    private String title;
    @NotBlank
    private Dictionary<StaffMember, StaffTypes> staff;
    private ObjectId mangaId;
}
