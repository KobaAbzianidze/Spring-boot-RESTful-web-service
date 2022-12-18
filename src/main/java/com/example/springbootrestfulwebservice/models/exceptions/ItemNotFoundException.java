package com.example.springbootrestfulwebservice.models.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(){
        super("Item not found!");
    }

    public ItemNotFoundException(final String message){
        super(message);
    }

    public ItemNotFoundException(final Long id){
        super(String.format("Could not find Item with given id: {%d}" , id));
    }
}
