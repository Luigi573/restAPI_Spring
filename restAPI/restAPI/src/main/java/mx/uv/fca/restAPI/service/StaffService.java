package mx.uv.fca.restAPI.service;

import java.util.List;

import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.mapper.StaffMemberMapper;
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
    @Autowired
    private StaffMemberMapper mapper;

    public StaffMemberDTO addStaffMember(StaffMemberDTO staffDTO) {
        StaffMember staff = mapper.toModel(staffDTO);
        repository.save(staff);

        return mapper.toDTO(staff);
    }

    public List<StaffMemberDTO> getStaffMembers() {
        List<StaffMember> staffList = repository.findAll();

        return mapper.toDTOs(staffList);
    }

    public List<StaffMemberDTO> getStaffMembersByType(StaffTypes type) {
        List<StaffMember> staffList = repository.findByType(type);

        return mapper.toDTOs(staffList);
    }

    public void updateStaffMemberInfo(StaffMemberDTO staffDTO) {
        StaffMember staff = mapper.toModel(staffDTO);
        repository.save(staff);
    }

    public void deleteStaffMember(ObjectId id) {
        repository.deleteById(id);
    }
}
