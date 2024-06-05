package mx.uv.fca.restAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import mx.uv.fca.restAPI.dto.ChapterDTO;
import mx.uv.fca.restAPI.dto.MangaDTO;
import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.model.StaffTypes;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
                .andExpect(jsonPath("$.releaseDate").value(manga.getReleaseDate().toString()))
                .andDo(print());
    }
    
    @Test
    void testAddMangaInvalid() throws Exception {
        MangaDTO manga = new MangaDTO();
        
        mockMvc.perform(post("/mangas/addManga")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(manga)))
                .andExpect(status().isBadRequest())
                .andDo(print());
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
    void testGetMangaById() throws Exception {
        MangaDTO manga = new MangaDTO();
        manga.setId(new ObjectId("665a0dd7a9384af6a6951a7d"));
        manga.setAuthor("Takata");
        manga.setReleaseDate(LocalDate.of(2020, Month.NOVEMBER, 30));
        manga.setTitle("Class de 2 banme ni kawaii Onna no ko to Tomodachi ni natta");

        when(mangaService.getMangaById(manga.getId())).thenReturn(Optional.of(manga));

        mockMvc.perform(get("/mangas/id/{id}", manga.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value(manga.getAuthor()))
                .andExpect(jsonPath("$.releaseDate").value(manga.getReleaseDate().toString()))
                .andExpect(jsonPath("$.title").value(manga.getTitle()))
                .andDo(print());
    }
    
    @Test
    void testGetMangaByIdNotFound() throws Exception {
        ObjectId mangaId = new ObjectId("665a0dd7a9384af6a6951a7d");

        when(mangaService.getMangaById(mangaId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/mangas/id/{id}", mangaId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
    
     @Test
    void testGetMangaByTitle() throws Exception {
        MangaDTO manga = new MangaDTO();
        manga.setId(new ObjectId("665a0dd7a9384af6a6951a7d"));
        manga.setAuthor("Takata");
        manga.setReleaseDate(LocalDate.of(2020, Month.NOVEMBER, 30));
        manga.setTitle("Class de 2 banme ni kawaii Onna no ko to Tomodachi ni natta");

        when(mangaService.getMangaByTitle(manga.getTitle())).thenReturn(Optional.of(manga));

        mockMvc.perform(get("/mangas/title/{title}", manga.getTitle())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value(manga.getAuthor()))
                .andExpect(jsonPath("$.releaseDate").value(manga.getReleaseDate().toString()))
                .andExpect(jsonPath("$.title").value(manga.getTitle()))
                .andDo(print());
    }

    @Test
    void testGetMangaByTitleNotFound() throws Exception {
        String title = "Netoge no yome ga ninki idol datta";

        when(mangaService.getMangaByTitle(title)).thenReturn(Optional.empty());

        mockMvc.perform(get("/mangas/title/{title}", title)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
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
    void testUpdateMangaInvalid() throws Exception {
        MangaDTO manga = new MangaDTO();
        
        mockMvc.perform(put("/mangas/updateManga")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(manga)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void testDeleteManga() throws Exception{
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");

        mockMvc.perform(delete("/mangas/id/{id}/delete", mangaId))
                .andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    void testPostChapter() throws Exception {
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
                .andExpect(jsonPath("$.staff[0].type").value("TRANSLATOR"))
                .andExpect(jsonPath("$.staff[1].name").value(member2.getName()))
                .andExpect(jsonPath("$.staff[1].type").value("REDRAWER"))
                .andDo(print());
    }
    
    @Test
    void testPostChapterInvalid() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ChapterDTO chapter = new ChapterDTO();
        
        mockMvc.perform(post("/mangas/id/{mangaId}/postChapter", mangaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chapter)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
    
    @Test
    void testGetChapter() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ChapterDTO chapter = new ChapterDTO();
        chapter.setTitle("Secret Friend");
        chapter.setMangaId(mangaId);
        chapter.setNumber(2.0f);
        
        ArrayList<StaffMemberDTO> staff = new ArrayList();
        StaffMemberDTO member1 = new StaffMemberDTO();
        member1.setName("TheLuigi573");
        member1.setType(StaffTypes.TRANSLATOR);
        staff.add(member1);

        StaffMemberDTO member2 = new StaffMemberDTO();
        member2.setName("yosorou");
        member2.setType(StaffTypes.REDRAWER);
        staff.add(member2);
        
        chapter.setStaff(staff);
        
        when(chapterService.getChapter(mangaId, chapter.getNumber())).thenReturn(Optional.of(chapter));
        
        mockMvc.perform(get("/mangas/id/{mangaId}/chapter/{chapterNumber}", mangaId, chapter.getNumber()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(chapter.getNumber()))
                .andExpect(jsonPath("$.title").value(chapter.getTitle()))
                .andExpect(jsonPath("$.staff[0].name").value(member1.getName()))
                .andExpect(jsonPath("$.staff[0].type").value("TRANSLATOR"))
                .andExpect(jsonPath("$.staff[1].name").value(member2.getName()))
                .andExpect(jsonPath("$.staff[1].type").value("REDRAWER"))
                .andDo(print());
    }
    
    @Test
    void testGetChapterNotFound() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        float number = 23.1f;
        
        when(chapterService.getChapter(mangaId, number)).thenReturn(Optional.empty());
        
        mockMvc.perform(get("/mangas/id/{mangaId}/chapter/{number}", mangaId, number))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void testGetMangaChapters() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ChapterDTO chapter1 = new ChapterDTO();
        chapter1.setMangaId(new ObjectId("665a0dd7a9384af6a6951a7d"));
        chapter1.setTitle("Dating Etiquette");
        chapter1.setNumber(23.1f);

        ChapterDTO chapter2 = new ChapterDTO();
        chapter2.setMangaId(new ObjectId("665a0dd10fd77eb62c941d9c"));
        chapter2.setTitle("Meeting after a long time");
        chapter2.setNumber(22.1f);
        
        when(chapterService.getMangaChapters(mangaId)).thenReturn(Arrays.asList(chapter1, chapter2));

        mockMvc.perform(get("/mangas/id/{mangaId}/chapters", mangaId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].title").value(chapter1.getTitle()))
                .andExpect(jsonPath("$[0].number").value(chapter1.getNumber()))
                .andExpect(jsonPath("$[1].title").value(chapter2.getTitle()))
                .andExpect(jsonPath("$[1].number").value(chapter2.getNumber()))
                .andDo(print());
    }

    @Test
    void testUpdateChapter() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ChapterDTO chapter = new ChapterDTO();
        chapter.setId(new ObjectId("665ab143d28c946e03e3ed0c"));
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
        
        mockMvc.perform(put("/mangas/id/{mangaId}/chapter/{chapterId}/update", mangaId, chapter.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chapter)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    void testUpdateChapterInvalid() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ChapterDTO chapter = new ChapterDTO();
        chapter.setId(new ObjectId("665ab143d28c946e03e3ed0c"));
        
        mockMvc.perform(put("/mangas/id/{mangaId}/chapter/{chapterId}/update", mangaId, chapter.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chapter)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
    
    @Test
    void testDeleteChapter() throws Exception {
        ObjectId mangaId = new ObjectId("66576c2361a5964afa6bbd4e");
        ObjectId chapterId = new ObjectId("66576e92361c4919d860a0dc");

        mockMvc.perform(delete("/mangas/id/{mangaId}/chapter/{chapterId}/delete", mangaId, chapterId))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
