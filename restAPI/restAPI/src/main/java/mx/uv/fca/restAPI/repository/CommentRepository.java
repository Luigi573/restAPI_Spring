package mx.uv.fca.restAPI.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import mx.uv.fca.restAPI.model.Comment;
import mx.uv.fca.restAPI.repository.interfaces.ICommentRepository;

@Repository
public class CommentRepository implements ICommentRepository {
    @Autowired
    private MongoTemplate template;

    public ObjectId addComment(Comment comment) {
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
}