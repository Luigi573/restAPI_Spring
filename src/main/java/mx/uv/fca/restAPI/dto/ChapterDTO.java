package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


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

    @NotNull(message = "Staff members not defined")
    private List<StaffMemberDTO> staff;
    
    @NotNull(message = "MangaID no definido")
    private ObjectId mangaId;
}
