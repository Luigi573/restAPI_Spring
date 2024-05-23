package mx.uv.fca.restAPI.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.uv.fca.restAPI.dto.StaffMemberDTO;
import mx.uv.fca.restAPI.service.StaffService;
import mx.uv.fca.restAPI.model.StaffTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService service;

    @PostMapping("/add")
    public ResponseEntity<StaffMemberDTO> addStaffMember(@Valid @RequestBody StaffMemberDTO staffMember) {
        return new ResponseEntity<StaffMemberDTO>(service.addStaffMember(staffMember), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StaffMemberDTO>> getStaffMembers() {
        return new ResponseEntity<List<StaffMemberDTO>>(service.getStaffMembers(), HttpStatus.OK);
    }

    @GetMapping("/{staffType}")
    public ResponseEntity<List<StaffMemberDTO>> getStaffMembersByType(@PathVariable StaffTypes staffType) {
        return new ResponseEntity<List<StaffMemberDTO>>(service.getStaffMembersByType(staffType, HttpStatus.OK));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateStaffMember(@Valid @RequestBody StaffMemberDTO staffMember) {
        service.updateStaffMember(staffMember);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<Void> deleteStaffMember(@PathVariable ObjectId staffId) {
        service.deleteStaffMember(staffId);
        return ResponseEntity.ok().build();
    }
}
