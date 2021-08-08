package com.ecomerce.shopback.service;


import com.ecomerce.shopback.exception.CartNotFoundException;
import com.ecomerce.shopback.model.Cart;
import com.ecomerce.shopback.model.CartItem;
import com.ecomerce.shopback.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart findCartById(Long id){
        return cartRepository.findCartById(id).orElseThrow(() -> new CartNotFoundException("Cart by id "+id+" not found"));
    }

    public Cart countTotalprice(Cart cart){
        long totalPrice = 0;
        for (CartItem myItems:cart.getCartItems()) {
            totalPrice += myItems.getPrice();
        }
        cart.setTotalPrice(Long.valueOf(totalPrice));
        return cartRepository.save(cart);
    }

}
