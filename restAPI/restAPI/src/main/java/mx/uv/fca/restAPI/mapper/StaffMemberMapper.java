package mx.uv.fca.restAPI.mapper;

import java.util.List;
import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.model.StaffMember;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StaffMemberMapper {
    StaffMemberDTO toDTO(StaffMember model);
    StaffMember toModel(StaffMemberDTO dto);
    List<StaffMemberDTO> toDTOs(List<StaffMember> models);
    List<StaffMember> toModels(List<StaffMemberDTO> dtos);
}