package mx.uv.fca.restAPI.model;

import java.time.LocalDateTime;
import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comments")
public class Comment {
    @NonNull
    private Chapter chapter;
    private LocalDateTime postDate;
    private String commenter;
    private String content;

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}