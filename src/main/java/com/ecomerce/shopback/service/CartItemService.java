package com.ecomerce.shopback.service;

import com.ecomerce.shopback.exception.CartItemNotFoundException;
import com.ecomerce.shopback.model.CartItem;
import com.ecomerce.shopback.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> findAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem updateCartItems(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(CartItem cartItem) {
        cartItemRepository.deleteCartItemById(cartItem);
    }

    public CartItem findCartItemById(Long id) {
        return cartItemRepository.findCartItemById(id).orElseThrow(() -> new CartItemNotFoundException("Item with id " + id + "not found in cart"));
    }

    public CartItem changeCartItemQuantity(CartItem cartItem, Long quantity) {
        cartItem.setQuantity(quantity);
        return cartItemPrice(cartItem);
    }

    public CartItem cartItemPrice(CartItem cartItem) {
        long price = Long.parseLong(cartItem.getProduct().getPrice());
        long quantity = cartItem.getQuantity();
        cartItem.setPrice(Long.valueOf(price * quantity));
        return cartItemRepository.save(cartItem);
    }

}
