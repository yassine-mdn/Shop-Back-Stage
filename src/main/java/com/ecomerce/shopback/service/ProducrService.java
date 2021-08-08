package com.ecomerce.shopback.service;

import com.ecomerce.shopback.exception.ProductNotFoundException;
import com.ecomerce.shopback.model.Product;
import com.ecomerce.shopback.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducrService {

    private final ProductRepository productRepository;

    @Autowired
    public ProducrService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> productList() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product with id "+id+" not found"));
    }
}
