package com.example.springbootrestfulwebservice.services;

import com.example.springbootrestfulwebservice.models.Item;
import com.example.springbootrestfulwebservice.models.exceptions.ItemNotFoundException;
import com.example.springbootrestfulwebservice.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item addItem(final Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return this.itemRepository.findAll();
    }

    @Override
    public Item getItemById(final Long id) {
        return this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public Item getItemBySerialNumber(final String serialNumber){
        return this.itemRepository.findBySerialNumber(serialNumber).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public Item updateItemById(final Long id , final Item givenItem){
        final Item item = getItemById(id);
        item.setSerialNumber(givenItem.getSerialNumber());
        return this.itemRepository.save(item);
    }

    @Override
    public Item updateItemBySerialNumber(final String serialNumber , final Item givenItem){
        final Item item = getItemBySerialNumber(serialNumber);
        item.setSerialNumber(givenItem.getSerialNumber());
        return this.itemRepository.save(item);
    }

    @Override
    public Item deleteItem(final Long id){
        final Item item = getItemById(id);
        this.itemRepository.deleteById(id);
        return item;
    }

    @Override
    public Item deleteBySerialNumber(final String serialNumber){
        final Item item = getItemBySerialNumber(serialNumber);
        this.itemRepository.deleteBySerialNumber(serialNumber);
        return item;
    }

}
