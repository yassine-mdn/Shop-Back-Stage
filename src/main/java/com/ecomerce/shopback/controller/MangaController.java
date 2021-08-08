package com.ecomerce.shopback.controller;

import com.ecomerce.shopback.model.Mangas;
import com.ecomerce.shopback.model.Product;
import com.ecomerce.shopback.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MangaController {

    @Autowired
    private final MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("/mangas")
    public ResponseEntity<List<Mangas>> getAllMangas(){
        List<Mangas> MangaList = mangaService.findAllMangas();
        return new ResponseEntity<>(MangaList, HttpStatus.OK);
    }

    @GetMapping("mangas/{id}/products")
    public ResponseEntity<List<Product>> getProductsByMangaId(@PathVariable("id") Long id){
        List<Product> productList = mangaService.findMangaById(id).getMangaVolumes();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
