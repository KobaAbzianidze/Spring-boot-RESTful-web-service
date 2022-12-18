package com.example.springbootrestfulwebservice.models.exceptions;

import java.text.MessageFormat;

public class ItemAlreadyAssignedException extends RuntimeException{

    public ItemAlreadyAssignedException(){
        super("Item already assigned!");
    }

    public ItemAlreadyAssignedException(final Long cartId , final Long itemId){
        super(String.format("Could not assign item with id: {%d} to cart with id: {%d}" , itemId , cartId));
    }
}
