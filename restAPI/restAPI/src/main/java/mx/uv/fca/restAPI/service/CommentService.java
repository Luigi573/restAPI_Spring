package mx.uv.fca.restAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.dto.CommentDTO;
import mx.uv.fca.restAPI.model.Comment;
import mx.uv.fca.restAPI.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public void postComment(CommentDTO commentDTO) {
        Comment comment = new Comment();

        comment.setChapter(commentDTO.getChapter());

        repository.addComment(comment);
    }
}
