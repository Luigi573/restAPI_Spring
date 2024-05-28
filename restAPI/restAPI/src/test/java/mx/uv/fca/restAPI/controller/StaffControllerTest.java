package mx.uv.fca.restAPI.controller;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.uv.fca.restAPI.RestApiApplication;
import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Add any necessary setup here
    }

    @Test
    public void testAddStaffMember() throws Exception {
        StaffMemberDTO staffMember = new StaffMemberDTO();
        staffMember.setName("John Doe");
        staffMember.setJoinDate(LocalDate.now());
        staffMember.setType(StaffTypes.TRANSLATOR);
        

        mockMvc.perform(post("/staff/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(staffMember)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.staffType").value("ADMIN"))
                .andDo(print());
    }

    @Test
    public void testGetStaffMembers() throws Exception {
        mockMvc.perform(get("/staff")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andDo(print());
    }

    @Test
    public void testGetStaffMembersByType() throws Exception {
        mockMvc.perform(get("/staff/TEACHER")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andDo(print());
    }

    @Test
    public void testUpdateStaffMember() throws Exception {
        /*StaffMemberDTO staffMember = new StaffMemberDTO("John Doe", "john.doe@example.com", StaffTypes.ADMIN);

        mockMvc.perform(put("/staff/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(staffMember)))
                .andExpect(status().isOk())
                .andDo(print());*/
    }

    @Test
    public void testDeleteStaffMember() throws Exception {
        ObjectId staffId = new ObjectId("507f1f77bcf86cd799439011");

        mockMvc.perform(delete("/staff/delete/{staffId}", staffId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
