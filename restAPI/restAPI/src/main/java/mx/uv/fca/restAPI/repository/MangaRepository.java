package mx.uv.fca.restAPI.repository;

import java.util.List;
import mx.uv.fca.restAPI.model.Chapter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MangaRepository {
    @Autowired
    private MongoTemplate template;

    public ObjectId postChapter(Chapter chapter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postChapter'");
    }

    public List<Chapter> getMangaChapters(ObjectId _id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMangaChapters'");
    }

    public void updateChapter(Chapter older, Chapter newer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateChapter'");
    }

    public void deleteChapter(ObjectId chapterId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteChapter'");
    }
}
