package com.example.springbootrestfulwebservice.services;

import com.example.springbootrestfulwebservice.models.Cart;

import java.util.List;

public interface CartService {

    Cart addCart(final Cart cart);
    List<Cart> getCarts();
    Cart getCartById(final Long id);
    Cart getCartByName(final String name);
    Cart updateCartById(final Long id, final Cart givenCart);
    Cart updateCartByName(final String name , final Cart givenCart);
    Cart deleteCartById(final Long id);
    Cart deleteByName(final String name);
    Cart addItemToCart(final Long cartId , final Long itemId);
    Cart deleteItemFromCart(final Long cartId , final Long itemId);
}
