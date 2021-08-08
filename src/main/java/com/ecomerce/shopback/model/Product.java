package com.ecomerce.shopback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@AllArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String category;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String price;
    @NotNull
    @Min(0)
    private Long units;
    @NotNull
    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manga_id", referencedColumnName = "id")
    private Mangas manga;

    public Product() {

    }
}
