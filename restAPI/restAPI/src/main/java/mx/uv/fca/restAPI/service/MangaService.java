package mx.uv.fca.restAPI.service;

import java.util.List;
import java.util.Optional;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.mapper.MangaMapper;
import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.model.Manga;
import mx.uv.fca.restAPI.repository.ChapterRepository;
import mx.uv.fca.restAPI.repository.MangaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangaService {
    @Autowired
    private MangaRepository mangaRepository;
    @Autowired
    private MangaMapper mangaMapper;
    @Autowired
    private ChapterRepository chapterRepository;

    public MangaDTO saveManga(MangaDTO mangaDTO) {
        Manga manga = mangaMapper.toModel(mangaDTO);
        manga = mangaRepository.save(manga);

        return mangaMapper.toDTO(manga);
    }

    public List<MangaDTO> getMangas() {
        List<Manga> mangaList = mangaRepository.findAll();

        return mangaMapper.toDTOs(mangaList);
    }

    public Optional<MangaDTO> getMangaById(ObjectId id) {
        Optional<Manga> mangaOptional = mangaRepository.findById(id);

        if (mangaOptional.isPresent()) {
            Manga manga = mangaOptional.get();
            MangaDTO mangaDTO = mangaMapper.toDTO(manga);
            return Optional.of(mangaDTO);
        } else {
            return Optional.empty();
        }
    }

    public Optional<MangaDTO> getMangaByTitle(String title) {
        Optional<Manga> mangaOptional = mangaRepository.findByTitle(title);

        if (mangaOptional.isPresent()) {
            Manga manga = mangaOptional.get();
            MangaDTO mangaDTO = mangaMapper.toDTO(manga);
            return Optional.of(mangaDTO);
        } else {
            return Optional.empty();
        }
    }

    public void updateManga(MangaDTO mangaDTO) {
        Manga manga = mangaMapper.toModel(mangaDTO);
        mangaRepository.save(manga);
    }

    public void deleteManga(ObjectId mangaId) {
        List<Chapter> chapters = chapterRepository.findByMangaId(mangaId);

        for (Chapter chapter : chapters) {
            chapterRepository.delete(chapter);
        }
    }
}
