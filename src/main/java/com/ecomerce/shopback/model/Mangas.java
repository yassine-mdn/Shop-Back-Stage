package com.ecomerce.shopback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mangas")
@Setter
@Getter
@AllArgsConstructor
public class Mangas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String genres;
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "manga")
    List<Product> mangaVolumes = new ArrayList<>();

    public Mangas() {

    }
}
