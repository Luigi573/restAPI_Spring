package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.model.Chapter;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ChapterMapper {
    @Mapping(target = "id", source = "model.id.toHexString")
    ChapterDTO toDTO(Chapter model);

    @Mapping(target = "id", expression = "java(new ObjectId(dto.getId()))")
    Chapter toModel(ChapterDTO dto);
}