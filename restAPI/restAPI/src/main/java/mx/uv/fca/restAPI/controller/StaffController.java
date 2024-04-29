package mx.uv.fca.restAPI.controller;

import mx.uv.fca.restAPI.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class StaffController {
    @Autowired
    private StaffService service;
}
