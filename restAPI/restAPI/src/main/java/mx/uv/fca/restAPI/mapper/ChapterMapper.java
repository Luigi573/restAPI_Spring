package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.model.Chapter;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ChapterMapper {
    @Mapping(target = "_id", source = "model.id.toHexString")
    ChapterDTO toDTO(Chapter model);

    @Mapping(target = "_id", expression = "java(new ObjectId(dto.getId()))")
    Chapter toModel(ChapterDTO dto);

    List<ChapterDTO> toDTOs(List<Chapter> model);

    List<Chapter> toModels(List<ChapterDTO> dto);
}