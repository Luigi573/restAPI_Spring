package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.uv.fca.restAPI.model.StaffMember;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("chapters")
public class ChapterDTO {
    private ObjectId id;

    @Min(value = 1, message = "El capítulo debe ser un número mayor a 1")
    private float number;

    @NotBlank(message = "Título no definido")
    private String title;

    @NonNull
    private List<StaffMember> staff;
    
    @NotBlank(message = "MangaID no definido")
    private ObjectId mangaId;
}
