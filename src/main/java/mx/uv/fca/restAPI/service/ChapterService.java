package mx.uv.fca.restAPI.service;

import java.util.List;
import java.util.Optional;
import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.mapper.ChapterMapper;
import mx.uv.fca.restAPI.model.Chapter;
import mx.uv.fca.restAPI.repository.ChapterRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private ChapterRepository chapterRepository;

    public ChapterDTO postChapter(ChapterDTO chapterDTO) {
        Chapter chapter = chapterMapper.toModel(chapterDTO);
        chapter = chapterRepository.save(chapter);

        return chapterMapper.toDTO(chapter);
    }

    public List<ChapterDTO> getMangaChapters(ObjectId mangaId) {
        List<ChapterDTO> chapterList = chapterMapper.toDTOs(chapterRepository.findByMangaId(mangaId));

        return chapterList;
    }

    public Optional<ChapterDTO> getChapter(ObjectId mangaId, float number) {
        Optional<Chapter> chapter = chapterRepository.findByMangaIdAndNumber(mangaId, number);
        Optional<ChapterDTO> result = Optional.empty();

        if (chapter.isPresent()) {
            ChapterDTO dto = chapterMapper.toDTO(chapter.get());
            result = Optional.of(dto);
        }

        return result;
    }

    public void updateChapter(ChapterDTO chapterDTO) {
        Chapter chapter = chapterMapper.toModel(chapterDTO);
        chapterRepository.save(chapter);
    }

    public void deleteChapter(ObjectId chapterId) {
        chapterRepository.deleteById(chapterId);
    }
}
