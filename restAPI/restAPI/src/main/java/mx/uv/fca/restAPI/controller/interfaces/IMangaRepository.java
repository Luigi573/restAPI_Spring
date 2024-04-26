package mx.uv.fca.restAPI.controller.interfaces;

import mx.uv.fca.restAPI.model.Chapter;
import org.bson.types.ObjectId;

public interface IMangaRepository {
    public ObjectId postChapter(Chapter chapter);
}
