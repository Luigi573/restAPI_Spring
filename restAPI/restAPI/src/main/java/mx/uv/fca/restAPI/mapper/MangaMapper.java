package mx.uv.fca.restAPI.mapper;

import java.util.List;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.model.Manga;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MangaMapper {
    MangaDTO toDTO(Manga model);
    Manga toModel(MangaDTO dto);
    List<MangaDTO> toDTOs(List<Manga> models);
    List<Manga> toModels(List<MangaDTO> dtos);
}