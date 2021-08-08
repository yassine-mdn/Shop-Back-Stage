package com.ecomerce.shopback.repository;

import com.ecomerce.shopback.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findCartById(Long id);
}
