package mx.uv.fca.restAPI.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.model.Manga;
import mx.uv.fca.restAPI.repository.ChapterRepository;
import mx.uv.fca.restAPI.repository.MangaRepository;

@Service
public class MangaService {
    @Autowired
    private MangaRepository mangaRepository;
    @Autowired
    private ChapterRepository chapterRepository;

    public Manga saveManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    public void updateManga(Manga manga) {
        mangaRepository.save(manga);
    }

    public void deleteManga(ObjectId mangaId) {
        List<Chapter> chapters = chapterRepository.findByMangaId(mangaId);

        for (Chapter chapter : chapters) {
            chapterRepository.delete(chapter);
        }

        mangaRepository.deleteById(mangaId);
    }

    public Chapter postChapter(Chapter chapter, ObjectId mangaId) {
        chapter.setMangaId(mangaId);
        return chapterRepository.save(chapter);
    }

    public List<Chapter> getMangaChapters(ObjectId mangaId) {
        return chapterRepository.findByMangaId(mangaId);
    }

    public void updateChapter(Chapter chapter) {
        chapterRepository.save(chapter);
    }

    public void deleteChapter(Chapter chapter) {
        chapterRepository.delete(chapter);
    }
}
