package mx.uv.fca.restAPI.mapper;

import java.util.List;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.model.Manga;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MangaMapper {
    @Mapping(target = "id", source = "model.id.toHexString")
    MangaDTO toDTO(Manga model);

    @Mapping(target = "id", expression = "java(new ObjectId(dto.getId()))")
    Manga toModel(MangaDTO dto);

    List<MangaDTO> toDTOs(List<Manga> models);

    List<Manga> toModels(List<MangaDTO> dtos);
}