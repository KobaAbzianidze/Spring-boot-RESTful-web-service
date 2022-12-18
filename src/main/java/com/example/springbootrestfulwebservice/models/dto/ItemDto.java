package com.example.springbootrestfulwebservice.models.dto;

import com.example.springbootrestfulwebservice.models.Item;

public record ItemDto(Long id, String serialNumber) {

    public static ItemDto from(final Item item){
        return new ItemDto(item.getId() , item.getSerialNumber());
    }

}
