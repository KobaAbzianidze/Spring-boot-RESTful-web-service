package com.example.springbootrestfulwebservice.models.exceptions;

public class CartNotFoundException extends RuntimeException{

    public CartNotFoundException(){
        super("Cart not found!");
    }

    public CartNotFoundException(final String message){
        super(message);
    }

    public CartNotFoundException(final Long id){
        super(String.format("Could not find Cart with given id: {%d}" , id));
    }
}
