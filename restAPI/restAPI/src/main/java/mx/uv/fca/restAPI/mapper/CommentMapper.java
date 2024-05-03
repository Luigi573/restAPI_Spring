package mx.uv.fca.restAPI.mapper;

import mx.uv.fca.restAPI.dto.CommentDTO;
import mx.uv.fca.restAPI.model.Comment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommentMapper {
    CommentDTO toDTO(Comment model);

    Comment toModel(CommentDTO dto);
}