package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class CommentDTO {
    @NonNull
    private ChapterDTO chapter;

    @NonNull
    private LocalDateTime postDate;

    @NonNull
    @Size(min = 10)
    private String commenter;

    @NonNull
    @Size(max = 300, message = "Contenido debe ser menor a 300 caracteres")
    private String content;

    private String id;
}