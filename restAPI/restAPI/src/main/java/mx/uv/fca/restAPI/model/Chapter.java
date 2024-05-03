package mx.uv.fca.restAPI.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Dictionary;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("chapters")
public class Chapter {
    private ObjectId _id;

    @Min(1)
    private float number;

    @NotBlank
    private String title;

    @NotBlank
    private Dictionary<StaffMember, StaffTypes> staff;

    public Chapter(float number, String title) {
        this.number = number;
        this.title = title;
    }
}
