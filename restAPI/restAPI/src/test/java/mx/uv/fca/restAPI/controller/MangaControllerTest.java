package mx.uv.fca.restAPI.controller;

import java.time.LocalDate;
import java.time.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.service.ChapterService;
import mx.uv.fca.restAPI.service.MangaService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    private static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void setUpClass() {
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
                .andExpect(jsonPath("$.title").value(manga.getTitle()))
                .andExpect(jsonPath("$.author").value(manga.getAuthor()))
                .andExpect(jsonPath("$.releaseDate").value(manga.getReleaseDate().toString()));
    }

    @Test
    void testDeleteChapter() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ObjectId chapterId = new ObjectId("66576e92361c4919d860a0dc");

        mockMvc.perform(delete("/mangas/id/{mangaId}/chapter/{chapterId}/delete", mangaId, chapterId))
                .andExpect(status().isOk());
    }

    @Test
    void testGetChapter() throws Exception {

    }

    @Test
    void testGetMangaById() throws Exception {

    }

    @Test
    void testGetMangaByTitle() throws Exception {

    }

    @Test
    void testGetMangaChapters() throws Exception {

    }

    @Test
    void testGetMangas() throws Exception {

    }

    @Test
    void testPostChapter() throws Exception {

    }

    @Test
    void testUpdateChapter() throws Exception {

    }

    @Test
    void testUpdateManga() throws Exception {

    }
}
