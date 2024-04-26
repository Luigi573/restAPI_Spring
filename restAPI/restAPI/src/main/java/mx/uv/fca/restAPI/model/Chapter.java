package mx.uv.fca.restAPI.model;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.Min;
import java.util.Dictionary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("chapters")
public class Chapter {
    private ObjectId _id;

    @Min(1)
    private float number;

    @NonNull
    private String title;
    private Dictionary<StaffMember, StaffTypes> staff;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
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
