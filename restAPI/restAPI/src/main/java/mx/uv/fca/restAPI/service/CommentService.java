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
        Comment comment = new Comment();

        comment.setChapter(new Chapter(commentDTO.getChapter().getNumber(), commentDTO.getChapter().getTitle()));
        comment.setCommenter(commentDTO.getCommenter());
        comment.setContent(commentDTO.getContent());
        comment.setPostDate(commentDTO.getPostDate());

        repository.addComment(comment);
    }
}
