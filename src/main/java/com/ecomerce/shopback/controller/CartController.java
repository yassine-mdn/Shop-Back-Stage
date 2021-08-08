package com.ecomerce.shopback.controller;

import com.ecomerce.shopback.model.Cart;
import com.ecomerce.shopback.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public String getCartById(@PathVariable("id") Long id){
        Cart cart = cartService.findCartById(id);
        return "cart";
    }
}
