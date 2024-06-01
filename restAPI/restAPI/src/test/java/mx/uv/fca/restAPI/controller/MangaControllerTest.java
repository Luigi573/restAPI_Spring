package mx.uv.fca.restAPI.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.model.StaffTypes;
import mx.uv.fca.restAPI.service.ChapterService;
import mx.uv.fca.restAPI.service.MangaService;

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
    void testGetMangas() throws Exception{
        MangaDTO manga1 = new MangaDTO();
        manga1.setId(new ObjectId("665a0dd7a9384af6a6951a7d"));
        manga1.setAuthor("Takata");
        manga1.setReleaseDate(LocalDate.of(2020, Month.NOVEMBER, 30));
        manga1.setTitle("Class de 2 banme ni kawaii Onna no ko to Tomodachi ni natta");

        MangaDTO manga2 = new MangaDTO();
        manga2.setId(new ObjectId("665a0dd10fd77eb62c941d9c"));
        manga2.setAuthor("Hirohiko Araki");
        manga2.setReleaseDate(LocalDate.of(1987, Month.JANUARY,1));
        manga2.setTitle("Jojo no kimyou na bouken");

        when(mangaService.getMangas()).thenReturn(Arrays.asList(manga1, manga2));

        mockMvc.perform(get("/mangas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].author").value(manga1.getAuthor()))
                .andExpect(jsonPath("$[0].title").value(manga1.getTitle()))
                .andExpect(jsonPath("$[0].releaseDate").value(manga1.getReleaseDate().toString()))
                .andExpect(jsonPath("$[1].author").value(manga2.getAuthor()))
                .andExpect(jsonPath("$[1].title").value(manga2.getTitle()))
                .andExpect(jsonPath("$[1].releaseDate").value(manga2.getReleaseDate().toString()))
                .andDo(print());
    }

    @Test
    void testUpdateManga() throws Exception{
        MangaDTO manga = new MangaDTO();
        manga.setAuthor("Takata");
        manga.setReleaseDate(LocalDate.of(2020, Month.NOVEMBER, 30));
        manga.setTitle("Class de 2 banme ni kawaii Onna no ko to Tomodachi ni natta");

        mockMvc.perform(put("/mangas/updateManga")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(manga)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteManga() throws Exception{
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");

        mockMvc.perform(delete("/mangas/id/{id}/delete", mangaId))
                .andExpect(status().isOk());
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

    //For some reason it won't run if I name it testPostChapter
    @Test
    void testChapter() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ChapterDTO chapter = new ChapterDTO();
        chapter.setTitle("Kindred Sprits");
        chapter.setMangaId(mangaId);
        chapter.setNumber(1.1f);

        ArrayList<StaffMemberDTO> staff = new ArrayList<>();
        StaffMemberDTO member1 = new StaffMemberDTO();
        member1.setName("TheLuigi573");
        member1.setType(StaffTypes.TRANSLATOR);
        staff.add(member1);

        StaffMemberDTO member2 = new StaffMemberDTO();
        member2.setName("Skynet");
        member2.setType(StaffTypes.REDRAWER);
        staff.add(member2);

        chapter.setStaff(staff);

        when(chapterService.postChapter(any(ChapterDTO.class))).thenReturn(chapter);

        mockMvc.perform(post("/mangas/id/{mangaId}/postChapter", mangaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chapter)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.number").value(chapter.getNumber()))
                .andExpect(jsonPath("$.title").value(chapter.getTitle()))
                .andExpect(jsonPath("$.staff[0].name").value(member1.getName()))
                .andExpect(jsonPath("$.staff[0].type").value(member1.getType().toString()))
                .andExpect(jsonPath("$.staff[1].name").value(member2.getName()))
                .andExpect(jsonPath("$.staff[1].type").value(member2.getType().toString()))
                .andDo(print());
    }

    @Test
    void testGetMangaByTitle() throws Exception {

    }

    @Test
    void testGetMangaChapters() throws Exception {

    }

    @Test
    void testUpdateChapter() throws Exception {

    }
}
