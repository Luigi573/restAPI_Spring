package mx.uv.fca.restAPI.controller.interfaces;

import java.util.List;
import mx.uv.fca.restAPI.model.Comment;
import org.bson.types.ObjectId;

public interface ICommentRepository {
    public ObjectId addComment(Comment comment);

    public List<Comment> getChapterComments(ObjectId chapterID);

    public void updateComment(ObjectId commentID, String content);

    public void deleteComment(ObjectId commentID);
}
