package com.example.springbootrestfulwebservice.models;

import com.example.springbootrestfulwebservice.models.dto.CartDto;
import com.example.springbootrestfulwebservice.models.dto.ItemDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , unique = true)
    private String serialNumber;

    @ManyToOne()
    private Cart cart;

    public Item(){}

    public Item(final String serialNumber){
        this.serialNumber = serialNumber;
    }

    public Item(final Long id ,final String serialNumber){
        this.id = id;
        this.serialNumber = serialNumber;
    }

    public static Item from(final ItemDto itemDto){
        return new Item(itemDto.id() , itemDto.serialNumber());
    }
}
