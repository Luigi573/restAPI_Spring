package mx.uv.fca.restAPI.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import mx.uv.fca.restAPI.interfaces.IStaffRepository;
import mx.uv.fca.restAPI.model.StaffMember;
import mx.uv.fca.restAPI.model.StaffTypes;

public class StaffRepository implements IStaffRepository {
    @Autowired
    private MongoTemplate template;

    @Override
    public ObjectId addStaffMember(StaffMember staff) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStaffMember'");
    }

    @Override
    public List<StaffMember> getStaffMembers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffMembers'");
    }

    @Override
    public List<StaffMember> getStaffMembersByType(StaffTypes type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffMembersByType'");
    }

    @Override
    public void updateStaffMemberInfo(StaffMember older, StaffMember newer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStaffMemberInfo'");
    }

    @Override
    public void deleteStaffMember(ObjectId _id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStaffMember'");
    }

}
