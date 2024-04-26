package mx.uv.fca.restAPI.model;

import java.util.Dictionary;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("chapters")
public class Chapter {
    private String number;
    private String title;
    private Dictionary<StaffMember, StaffTypes> staff;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dictionary<StaffMember, StaffTypes> getStaff() {
        return staff;
    }

    public void setStaff(Dictionary<StaffMember, StaffTypes> staff) {
        this.staff = staff;
    }
}
