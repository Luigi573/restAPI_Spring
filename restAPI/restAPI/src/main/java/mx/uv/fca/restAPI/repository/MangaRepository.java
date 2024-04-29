package mx.uv.fca.restAPI.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.repository.interfaces.IMangaRepository;

@Repository
public class MangaRepository implements IMangaRepository {
    @Autowired
    private MongoTemplate template;

    @Override
    public ObjectId postChapter(Chapter chapter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postChapter'");
    }

    @Override
    public List<Chapter> getMangaChapters(ObjectId _id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMangaChapters'");
    }

    @Override
    public void updateChapter(Chapter older, Chapter newer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateChapter'");
    }

    @Override
    public void deleteChapter(ObjectId chapterId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteChapter'");
    }

}
