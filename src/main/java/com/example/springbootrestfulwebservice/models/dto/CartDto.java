package com.example.springbootrestfulwebservice.models.dto;

import com.example.springbootrestfulwebservice.models.Cart;
import com.example.springbootrestfulwebservice.models.Item;

import java.util.List;

public record CartDto(Long id , String name , List<ItemDto> items) {
    public static CartDto from(final Cart cart){
        return new CartDto(cart.getId(), cart.getName() , cart.getItems().stream().map(ItemDto::from).toList());
    }
}
