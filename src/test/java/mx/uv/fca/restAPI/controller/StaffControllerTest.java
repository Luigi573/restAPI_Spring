package mx.uv.fca.restAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Arrays;
import java.time.LocalDate;
import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.model.StaffTypes;
import mx.uv.fca.restAPI.service.StaffService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StaffService service;
    private static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void setUpClass() {
        objectMapper.registerModule(new JavaTimeModule());
    }
    
    @Test
    public void testAddStaffMember() throws Exception {
        StaffMemberDTO staff = new StaffMemberDTO();
        staff.setJoinDate(LocalDate.now());
        staff.setName("TheLuigi573");
        staff.setType(StaffTypes.TRANSLATOR);
        
        when(service.addStaffMember(staff)).thenReturn(staff);
        
        mockMvc.perform(post("/staff/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(staff)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(staff.getName()))
                .andExpect(jsonPath("$.joinDate").value(staff.getJoinDate().toString()))
                .andExpect(jsonPath("$.type").value("TRANSLATOR"))
                .andDo(print());
    }
    
    @Test
    public void testAddStaffMemberInvalid() throws Exception {
        StaffMemberDTO staff = new StaffMemberDTO();
        
        mockMvc.perform(post("/staff/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(staff)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testGetStaffMembers() throws Exception {
        StaffMemberDTO staff1 = new StaffMemberDTO();
        staff1.setJoinDate(LocalDate.now());
        staff1.setName("TheLuigi573");
        staff1.setType(StaffTypes.TRANSLATOR);
        
        StaffMemberDTO staff2 = new StaffMemberDTO();
        staff2.setJoinDate(LocalDate.now());
        staff2.setName("Deacsot1");
        staff2.setType(StaffTypes.COLORIST);
        
        when(service.getStaffMembers()).thenReturn(Arrays.asList(staff1, staff2));
        
        mockMvc.perform(get("/staff")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value(staff1.getName()))
                .andExpect(jsonPath("$[0].joinDate").value(staff1.getJoinDate().toString()))
                .andExpect(jsonPath("$[0].type").value("TRANSLATOR"))
                .andExpect(jsonPath("$[1].name").value(staff2.getName()))
                .andExpect(jsonPath("$[1].joinDate").value(staff2.getJoinDate().toString()))
                .andExpect(jsonPath("$[1].type").value("COLORIST"))
                .andDo(print());
;
    }

    @Test
    public void testGetStaffMembersByType() throws Exception {
        StaffMemberDTO staff1 = new StaffMemberDTO();
        staff1.setJoinDate(LocalDate.now());
        staff1.setName("TheLuigi573");
        staff1.setType(StaffTypes.TRANSLATOR);
        
        StaffMemberDTO staff2 = new StaffMemberDTO();
        staff2.setJoinDate(LocalDate.now());
        staff2.setName("Suldand");
        staff2.setType(StaffTypes.TRANSLATOR);
        
        when(service.getStaffMembersByType(StaffTypes.TRANSLATOR)).thenReturn(Arrays.asList(staff1, staff2));
        
        mockMvc.perform(get("/staff/{staffType}", "TRANSLATOR")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value(staff1.getName()))
                .andExpect(jsonPath("$[0].joinDate").value(staff1.getJoinDate().toString()))
                .andExpect(jsonPath("$[0].type").value("TRANSLATOR"))
                .andExpect(jsonPath("$[1].name").value(staff2.getName()))
                .andExpect(jsonPath("$[1].joinDate").value(staff2.getJoinDate().toString()))
                .andExpect(jsonPath("$[1].type").value("TRANSLATOR"))
                .andDo(print());
    }

    @Test
    public void testUpdateStaffMember() throws Exception {
        StaffMemberDTO staff = new StaffMemberDTO();
        staff.setId(new ObjectId("665acefd5fa3f440eef0b05f"));
        staff.setJoinDate(LocalDate.now());
        staff.setName("TheLuigi573");
        staff.setType(StaffTypes.TRANSLATOR);
                
        mockMvc.perform(put("/staff/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(staff)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    public void testUpdateStaffMemberInvalid() throws Exception {
        StaffMemberDTO staff = new StaffMemberDTO();
        
        mockMvc.perform(put("/staff/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(staff)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    public void testDeleteStaffMember() throws Exception {
        ObjectId id = new ObjectId("665acefd5fa3f440eef0b05f");
        
        mockMvc.perform(delete("/staff/delete/{staffId}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
