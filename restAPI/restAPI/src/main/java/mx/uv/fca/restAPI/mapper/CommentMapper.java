package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.CommentDTO;
import mx.uv.fca.restAPI.model.Comment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommentMapper {
    @Mapping(target = "id", source = "model.id.toHexString")
    CommentDTO toDTO(Comment model);

    @Mapping(target = "id", expression = "java(new ObjectId(dto.getId()))")
    Comment toModel(CommentDTO dto);
}