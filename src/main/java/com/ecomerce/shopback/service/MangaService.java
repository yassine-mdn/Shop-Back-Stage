package com.ecomerce.shopback.service;

import com.ecomerce.shopback.exception.MangaNotFoundException;
import com.ecomerce.shopback.exception.ProductNotFoundException;
import com.ecomerce.shopback.model.Mangas;
import com.ecomerce.shopback.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    @Autowired
    private final MangaRepository mangaRepository;


    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    public List<Mangas> findAllMangas(){
        return mangaRepository.findAll();
    }

    public Mangas findMangaById(Long id){
        return mangaRepository.findMangaById(id).orElseThrow(() -> new MangaNotFoundException("Manga with id "+id+" not found"));
    }
}
