package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.MagazineDTO;
import mx.uv.fca.restAPI.model.Magazine;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MagazineMapper {
    @Mapping(target = "id", source = "model.id.toHexString")
    MagazineDTO toDTO(Magazine model);

    @Mapping(target = "id", expression = "java(new ObjectId(dto.getId()))")
    Magazine toModel(MagazineDTO dto);

    List<MagazineDTO> toDTOs(List<Magazine> models);

    List<Magazine> toModels(List<MagazineDTO> dtos);
}