package mx.uv.fca.restAPI.repository.interfaces;

import java.util.List;
import mx.uv.fca.restAPI.model.Comment;
import org.bson.types.ObjectId;

public interface ICommentRepository {
    public void addComment(Comment comment);

    public List<Comment> getChapterComments(ObjectId c_id);

    public void updateComment(ObjectId _id, String content);

    public void deleteComment(ObjectId _id);
}
