package mx.uv.fca.restAPI.controller;

import java.util.List;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.service.CommentService;
import mx.uv.fca.restAPI.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    @Autowired
    private MangaService mangaService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/getAll")
    public List<MangaDTO> getMangas() {
        return mangaService.getMangas();
    }
}