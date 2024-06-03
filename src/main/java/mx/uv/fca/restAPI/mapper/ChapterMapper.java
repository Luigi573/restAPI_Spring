package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.model.Chapter;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ChapterMapper {
    ChapterDTO toDTO(Chapter model);
    Chapter toModel(ChapterDTO dto);
    List<ChapterDTO> toDTOs(List<Chapter> model);
    List<Chapter> toModels(List<ChapterDTO> dto);
}