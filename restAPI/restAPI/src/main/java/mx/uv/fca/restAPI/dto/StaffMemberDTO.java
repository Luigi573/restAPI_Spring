package mx.uv.fca.restAPI.dto;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document("staff")
public class StaffMemberDTO {
    @NonNull
    @Size(max = 100)
    private String name;

    @NonNull
    private LocalDateTime joinDate;

    @NonNull
    private StaffTypes type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public StaffTypes getType() {
        return type;
    }

    public void setType(StaffTypes type) {
        this.type = type;
    }
}
