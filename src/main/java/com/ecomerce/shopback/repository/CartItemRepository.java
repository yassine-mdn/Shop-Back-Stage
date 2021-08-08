package com.ecomerce.shopback.repository;

import com.ecomerce.shopback.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findCartItemById(Long id);

    void deleteCartItemById(CartItem cartItem);
}
