package mx.uv.fca.restAPI.controller;

import java.time.LocalDate;
import java.time.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.service.ChapterService;
import mx.uv.fca.restAPI.service.MangaService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MangaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MangaService mangaService;
    @MockBean
    private ChapterService chapterService;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setUpClass() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void testAddManga() throws Exception {
        MangaDTO manga = new MangaDTO();
        manga.setAuthor("Takata");
        manga.setReleaseDate(LocalDate.of(2020, Month.NOVEMBER, 30));
        manga.setTitle("Class de 2 banme ni kawaii Onna no ko to Tomodachi ni natta");

        when(mangaService.saveManga(manga)).thenReturn(manga);

        mockMvc.perform(post("/mangas/addManga")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(manga)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Class de 2 banme ni kawaii Onna no ko to Tomodachi ni natta"))
                .andExpect(jsonPath("$.author").value("Takata"));
    }

    @Test
    void testDeleteChapter() {

    }

    @Test
    void testGetChapter() {

    }

    @Test
    void testGetMangaById() {

    }

    @Test
    void testGetMangaByTitle() {

    }

    @Test
    void testGetMangaChapters() {

    }

    @Test
    void testGetMangas() {

    }

    @Test
    void testPostChapter() {

    }

    @Test
    void testUpdateChapter() {

    }

    @Test
    void testUpdateManga() {

    }
}
