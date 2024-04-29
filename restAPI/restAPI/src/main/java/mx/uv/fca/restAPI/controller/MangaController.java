package mx.uv.fca.restAPI.controller;

import mx.uv.fca.restAPI.service.CommentService;
import mx.uv.fca.restAPI.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class MangaController {
    @Autowired
    private MangaService mangaService;
    @Autowired
    private CommentService commentService;

}