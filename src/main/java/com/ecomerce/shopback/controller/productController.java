package com.ecomerce.shopback.controller;

import com.ecomerce.shopback.model.Product;
import com.ecomerce.shopback.service.ProducrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class productController {

    @Autowired
    private final ProducrService productService;

    public productController(ProducrService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.productList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("product/details/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
