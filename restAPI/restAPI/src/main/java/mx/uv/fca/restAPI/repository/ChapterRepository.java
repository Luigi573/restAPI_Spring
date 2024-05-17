package mx.uv.fca.restAPI.repository;

import java.util.List;
import mx.uv.fca.restAPI.model.Chapter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, ObjectId> {
    List<Chapter> findByMangaId(ObjectId mangaId);
}
