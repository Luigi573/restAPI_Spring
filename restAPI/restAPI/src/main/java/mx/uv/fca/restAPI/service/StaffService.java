package mx.uv.fca.restAPI.service;

import java.util.List;
import mx.uv.fca.restAPI.model.StaffMember;
import mx.uv.fca.restAPI.model.StaffTypes;
import mx.uv.fca.restAPI.repository.StaffRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;

    public ObjectId addStaffMember(StaffMember staff) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStaffMember'");
    }

    public List<StaffMember> getStaffMembers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffMembers'");
    }

    public List<StaffMember> getStaffMembersByType(StaffTypes type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffMembersByType'");
    }

    public void updateStaffMemberInfo(StaffMember older, StaffMember newer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStaffMemberInfo'");
    }

    public void deleteStaffMember(ObjectId _id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStaffMember'");
    }
}
