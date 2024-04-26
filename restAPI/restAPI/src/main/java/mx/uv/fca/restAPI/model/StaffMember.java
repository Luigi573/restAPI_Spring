package mx.uv.fca.restAPI.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("staff")
public class StaffMember {
    private String name;
    private LocalDateTime joinDate;
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
