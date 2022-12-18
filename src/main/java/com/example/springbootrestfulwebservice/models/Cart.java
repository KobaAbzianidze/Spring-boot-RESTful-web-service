package com.example.springbootrestfulwebservice.models;

import com.example.springbootrestfulwebservice.models.dto.CartDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",
    referencedColumnName = "id")
    private List<Item> items = new ArrayList<>();

    public Cart(){}

    public Cart(final String name){
        this.name = name;
    }

    public Cart(final Long id , final String name){
        this.id = id;
        this.name = name;
    }

    public Cart(final Long id , final String name , final List<Item> items){
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public void addItem(final Item item){
        this.items.add(item);
    }

    public void removeItem(final Item item){
        this.items.remove(item);
    }

    public static Cart from(final CartDto cartDto){
        return new Cart(cartDto.id(),  cartDto.name() , cartDto.items().stream().map(Item::from).toList());
    }
}

