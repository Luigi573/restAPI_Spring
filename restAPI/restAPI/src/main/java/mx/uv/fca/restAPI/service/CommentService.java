package mx.uv.fca.restAPI.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.dto.CommentDTO;
import mx.uv.fca.restAPI.mapper.CommentMapper;
import mx.uv.fca.restAPI.model.Comment;
import mx.uv.fca.restAPI.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;
    @Autowired
    private CommentMapper mapper;

    public CommentDTO postComment(CommentDTO commentDTO) {
        Comment comment = mapper.toModel(commentDTO);
        comment = repository.save(comment);

        return mapper.toDTO(comment);
    }

    public List<CommentDTO> getChapterComments(ObjectId chapterId) {
        List<Comment> commentList = repository.findByChapterId(chapterId);

        return mapper.toDTOs(commentList);
    }

    public void updateComment(CommentDTO commentDTO) {
        Comment comment = mapper.toModel(commentDTO);

        repository.save(comment);
    }

    public void deleteComment(ObjectId commentId) {
        repository.deleteById(commentId);
    }
}
