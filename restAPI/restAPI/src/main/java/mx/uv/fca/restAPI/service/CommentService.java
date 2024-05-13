package mx.uv.fca.restAPI.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.uv.fca.restAPI.dto.CommentDTO;
import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.model.Comment;
import mx.uv.fca.restAPI.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public void postComment(Comment comment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addComment'");
    }

    public List<Comment> getChapterComments(ObjectId chapterID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChapterComments'");
    }

    public void updateComment(ObjectId commentID, String content) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateComment'");
    }

    public void deleteComment(ObjectId commentID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteComment'");
    }

    private Comment toModel(CommentDTO dto) {
        Comment comment = new Comment();

        comment.setChapter(new Chapter(dto.getChapter().getNumber(), dto.getChapter().getTitle()));
        comment.setCommenter(dto.getCommenter());
        comment.setContent(dto.getContent());
        comment.setPostDate(dto.getPostDate());

        return comment;
    }
}
