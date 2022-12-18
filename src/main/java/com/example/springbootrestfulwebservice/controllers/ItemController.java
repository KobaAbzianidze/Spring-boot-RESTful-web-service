package com.example.springbootrestfulwebservice.controllers;

import com.example.springbootrestfulwebservice.models.Item;
import com.example.springbootrestfulwebservice.models.dto.ItemDto;
import com.example.springbootrestfulwebservice.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody final ItemDto itemDto){
        final Item item = this.itemService.addItem(Item.from(itemDto));
        return new ResponseEntity<>(ItemDto.from(item) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems(){
        final List<ItemDto> itemDto = this.itemService.getItems().stream().map(ItemDto::from).toList();
        return new ResponseEntity<>(itemDto, HttpStatus.OK);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<ItemDto> getItemsBYSerialNumber(@PathVariable("serialNumber") final String serialNumber){
        final ItemDto itemDto = ItemDto.from(this.itemService.getItemBySerialNumber(serialNumber));
        return new ResponseEntity<>(itemDto , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") final Long id){
        final ItemDto itemDto = ItemDto.from(this.itemService.getItemById(id));
        return new ResponseEntity<>(itemDto , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItemById(@PathVariable("id") final Long id,
                                                  @RequestBody final ItemDto itemDto){
        final Item item = this.itemService.updateItemById(id , Item.from(itemDto));
        return new ResponseEntity<>(ItemDto.from(item) , HttpStatus.OK);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<ItemDto> updateBySerialNumber(@PathVariable("serialNumber") final String serialNumber,
                                                        @RequestBody final ItemDto dto){
        final ItemDto itemDto = ItemDto.from(this.itemService.updateItemBySerialNumber(serialNumber , Item.from(dto)));
        return new ResponseEntity<>(itemDto , HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDto> deleteItemById(@PathVariable("id") final Long id , ResponseEntity<ItemDto> responseEntity){
        final ItemDto itemDto = ItemDto.from(this.itemService.deleteItem(id));
        return new ResponseEntity<>(itemDto , HttpStatus.OK);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<ItemDto> deleteItemBySerialNumber(@PathVariable("serialNumber") final String serialNumber){
        final ItemDto itemDto = ItemDto.from(this.itemService.deleteBySerialNumber(serialNumber));
        return new ResponseEntity<>(itemDto , HttpStatus.OK);
    }


}
