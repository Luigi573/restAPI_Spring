package mx.uv.fca.restAPI.controller;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.service.ChapterService;
import mx.uv.fca.restAPI.service.MangaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    @Autowired
    private MangaService mangaService;
    @Autowired
    private ChapterService chapterService;

    @PostMapping("/addManga")
    public ResponseEntity<MangaDTO> addManga(@Valid @RequestBody MangaDTO manga) {
        return new ResponseEntity<MangaDTO>(mangaService.saveManga(manga), HttpStatus.CREATED);
    }

    @PutMapping("/updateManga")
    public ResponseEntity<Void> updateManga(@Valid @RequestBody MangaDTO manga) {
        mangaService.updateManga(manga);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MangaDTO>> getMangas() {
        return new ResponseEntity<List<MangaDTO>>(mangaService.getMangas(), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<MangaDTO> getMangaByTitle(@PathVariable String title) {
        Optional<MangaDTO> manga = mangaService.getMangaByTitle(title);
        ResponseEntity<MangaDTO> result = ResponseEntity.notFound().build();

        if (manga.isPresent()) {
            result = ResponseEntity.ok(manga.get());
        }

        return result;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MangaDTO> getMangaById(@PathVariable ObjectId id) {
        Optional<MangaDTO> manga = mangaService.getMangaById(id);
        ResponseEntity<MangaDTO> result = ResponseEntity.notFound().build();

        if (manga.isPresent()) {
            result = ResponseEntity.ok(manga.get());
        }

        return result;
    }

    @PostMapping("/id/{mangaId}/postChapter")
    public ResponseEntity<ChapterDTO> postChapter(@PathVariable ObjectId mangaId,
            @Valid @RequestBody ChapterDTO chapterDTO) {
        chapterDTO.setMangaId(mangaId);
        return new ResponseEntity<ChapterDTO>(chapterService.postChapter(chapterDTO), HttpStatus.CREATED);
    }

    @GetMapping("/id/{mangaId}/chapters")
    public ResponseEntity<List<ChapterDTO>> getMangaChapters(@PathVariable ObjectId mangaId) {
        return new ResponseEntity<List<ChapterDTO>>(chapterService.getMangaChapters(mangaId), HttpStatus.OK);
    }

    @GetMapping("/id/{mangaId}/chapter/{chapterTitle}")
    public ResponseEntity<ChapterDTO> getChapter(@PathVariable ObjectId mangaId, @PathVariable String chapterTitle) {
        Optional<ChapterDTO> chapter = chapterService.getChapter(mangaId, chapterTitle);
        ResponseEntity<ChapterDTO> result = ResponseEntity.notFound().build();

        if (chapter.isPresent()) {
            result = ResponseEntity.ok(chapter.get());
        }

        return result;
    }

    @PutMapping("/id/{mangaId}/chapter/{chapterId}/update")
    public ResponseEntity<Void> updateChapter(@PathVariable ObjectId mangaId, @PathVariable ObjectId chapterId,
            @Valid @RequestBody ChapterDTO chapterDTO) {
        chapterDTO.setMangaId(mangaId);
        chapterDTO.setId(chapterId);
        chapterService.updateChapter(chapterDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id/{mangaId}/chapter/{chapterId}/delete")
    public ResponseEntity<Void> deleteChapter(@PathVariable ObjectId mangaId, @PathVariable ObjectId chapterId) {
        chapterService.deleteChapter(chapterId);
        return ResponseEntity.ok().build();
    }
}