package mx.uv.fca.restAPI.repository;

import mx.uv.fca.restAPI.model.Manga;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends MongoRepository<Manga, ObjectId> {
    Manga findByTitle(String title);
}
