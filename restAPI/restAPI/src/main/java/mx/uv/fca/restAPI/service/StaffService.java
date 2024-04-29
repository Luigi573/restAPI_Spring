package mx.uv.fca.restAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.repository.StaffRepository;

@Service
public class StaffService {
    @Autowired
    private StaffRepository repository;
}
