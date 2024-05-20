package mx.uv.fca.restAPI.controller;

import java.util.List;
import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    @Autowired
    private MangaService mangaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<MangaDTO>> getMangas() {
        return new ResponseEntity<>(mangaService.getMangas(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<MangaDTO> getMangaByTitle(@PathVariable String title) {
        return new ResponseEntity<MangaDTO>(mangaService.getMangaByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/{mangaId}/{chapterTitle}")
    public ResponseEntity<ChapterDTO> getChapter(@PathVariable String mangaId, @PathVariable String chapterTitle) {
        return new ResponseEntity<ChapterDTO>(mangaService.getChapter(chapterTitle), HttpStatus.OK);
    }
}