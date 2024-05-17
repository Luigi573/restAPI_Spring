package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.model.StaffMember;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StaffMemberMapper {
    @Mapping(target = "id", source = "model.id.toHexString")
    StaffMemberDTO toDTO(StaffMember model);

    @Mapping(target = "id", expression = "java(new ObjectId(dto.getId()))")
    StaffMember toModel(StaffMemberDTO dto);
}