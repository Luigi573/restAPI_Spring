package mx.uv.fca.restAPI.controller.interfaces;

import java.util.List;

import org.bson.types.ObjectId;

import mx.uv.fca.restAPI.model.StaffMember;
import mx.uv.fca.restAPI.model.StaffTypes;

public interface IStaffRepository {
    public ObjectId addStaffMember(StaffMember staff);

    public List<StaffMember> getStaffMembers();

    public List<StaffMember> getStaffMembersByType(StaffTypes type);

    public void updateStaffMemberInfo(StaffMember older, StaffMember newer);

    public void deleteStaffMember(ObjectId _id);
}