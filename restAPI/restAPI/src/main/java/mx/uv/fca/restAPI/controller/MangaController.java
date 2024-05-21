package mx.uv.fca.restAPI.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.service.ChapterService;
import mx.uv.fca.restAPI.service.MangaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    @Autowired
    private MangaService mangaService;
    @Autowired
    private ChapterService chapterService;

    @GetMapping("/addManga")
    public String addManga(@Valid @RequestBody MangaDTO manga) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<MangaDTO>> getMangas() {
        return new ResponseEntity<>(mangaService.getMangas(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<MangaDTO> getMangaByTitle(@PathVariable String title) {
        Optional<MangaDTO> manga = mangaService.getMangaByTitle(title);
        ResponseEntity<MangaDTO> result = ResponseEntity.notFound().build();

        if (manga.isPresent()) {
            result = ResponseEntity.ok(manga.get());
        }

        return result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MangaDTO> getMangaById(@PathVariable ObjectId id) {
        Optional<MangaDTO> manga = mangaService.getMangaById(id);
        ResponseEntity<MangaDTO> result = ResponseEntity.notFound().build();

        if (manga.isPresent()) {
            result = ResponseEntity.ok(manga.get());
        }

        return result;
    }

    @GetMapping("/{mangaId}/chapter/{chapterTitle}")
    public ResponseEntity<ChapterDTO> getChapter(@PathVariable ObjectId mangaId, @PathVariable String chapterTitle) {
        Optional<ChapterDTO> chapter = chapterService.getChapter(mangaId, chapterTitle);
        ResponseEntity<ChapterDTO> result = ResponseEntity.notFound().build();

        if (chapter.isPresent()) {
            result = ResponseEntity.ok(chapter.get());
        }

        return result;
    }
}