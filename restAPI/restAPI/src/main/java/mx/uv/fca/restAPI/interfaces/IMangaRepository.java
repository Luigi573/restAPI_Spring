package mx.uv.fca.restAPI.interfaces;

import mx.uv.fca.restAPI.model.Chapter;

import java.util.List;

import org.bson.types.ObjectId;

public interface IMangaRepository {
    public ObjectId postChapter(Chapter chapter);

    public List<Chapter> getMangaChapters(ObjectId _id);

    public void updateChapter(Chapter older, Chapter newer);

    public void deleteChapter(ObjectId chapterId);
}
