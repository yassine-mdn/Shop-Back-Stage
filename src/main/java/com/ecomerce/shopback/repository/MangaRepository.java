package com.ecomerce.shopback.repository;

import com.ecomerce.shopback.model.Mangas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MangaRepository extends JpaRepository<Mangas, Long> {
    Optional<Mangas> findMangaById(Long id);
}
