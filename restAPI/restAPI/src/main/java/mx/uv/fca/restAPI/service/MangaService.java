package mx.uv.fca.restAPI.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.mapper.ChapterMapper;
import mx.uv.fca.restAPI.mapper.MangaMapper;
import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.model.Manga;
import mx.uv.fca.restAPI.repository.ChapterRepository;
import mx.uv.fca.restAPI.repository.MangaRepository;

@Service
public class MangaService {
    @Autowired
    private MangaRepository mangaRepository;
    @Autowired
    private MangaMapper mangaMapper;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private ChapterMapper chapterMapper;

    public MangaDTO saveManga(MangaDTO mangaDTO) {
        Manga manga = mangaMapper.toModel(mangaDTO);
        return mangaRepository.save(manga);
    }

    public void updateManga(MangaDTO manga) {
        mangaRepository.save(manga);
    }

    public void deleteManga(ObjectId mangaId) {
        List<Chapter> chapters = chapterRepository.findByMangaId(mangaId);

        for (Chapter chapter : chapters) {
            chapterRepository.delete(chapter);
        }

        mangaRepository.deleteById(mangaId);
    }

    public ChapterDTO postChapter(ChapterDTO chapterDTO, ObjectId mangaId) {
        Chapter chapter = chapterMapper.toModel(chapterDTO);
        chapter.setMangaId(mangaId);
        chapter = chapterRepository.save(chapter);

        return chapterMapper.toDTO(chapter);
    }

    public List<ChapterDTO> getMangaChapters(ObjectId mangaId) {
        List<ChapterDTO> chapterList = chapterMapper.toDTOs(chapterRepository.findByMangaId(mangaId));

        return chapterList;
    }

    public void updateChapter(ChapterDTO chapterDTO) {
        Chapter chapter = chapterMapper.toModel(chapterDTO);
        chapterRepository.save(chapter);
    }

    public void deleteChapter(ChapterDTO chapterDTO) {
        Chapter chapter = chapterMapper.toModel(chapterDTO);

        chapterRepository.delete(chapter);
    }
}
