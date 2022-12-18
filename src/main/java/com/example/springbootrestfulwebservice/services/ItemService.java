package com.example.springbootrestfulwebservice.services;

import com.example.springbootrestfulwebservice.models.Item;

import java.util.List;

public interface ItemService {

    Item addItem(final Item item);
    List<Item> getItems();
    Item getItemById(final Long id);
    Item getItemBySerialNumber(final String serialNumber);
    Item updateItemById(final Long id , final Item givenItem);
    Item updateItemBySerialNumber(final String serialNumber , final Item givenItem);
    Item deleteItem(final Long id);
    Item deleteBySerialNumber(final String serialNumber);

}
