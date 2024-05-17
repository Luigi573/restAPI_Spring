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

    public Comment postComment(Comment comment) {
        return repository.save(comment);
    }

    public List<CommentDTO> getChapterComments(ObjectId chapterID) {
        List<Comment> commentList = repository.findByChapterId(chapterID);

    }

    public void updateComment(ObjectId commentID, String content) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateComment'");
    }

    public void deleteComment(ObjectId commentID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteComment'");
    }
}
