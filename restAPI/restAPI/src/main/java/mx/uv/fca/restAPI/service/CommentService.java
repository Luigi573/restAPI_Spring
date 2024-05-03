package mx.uv.fca.restAPI.service;

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

    public void postComment(CommentDTO commentDTO) {
        repository.addComment(toModel(commentDTO));
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
