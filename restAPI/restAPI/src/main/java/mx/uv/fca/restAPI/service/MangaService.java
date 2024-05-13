package mx.uv.fca.restAPI.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.repository.MangaRepository;

@Service
public class MangaService {
    @Autowired
    private MangaRepository repository;

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
