package mx.uv.fca.restAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uv.fca.restAPI.repository.MangaRepository;

@Service
public class MangaService {
    @Autowired
    private MangaRepository repository;
}
