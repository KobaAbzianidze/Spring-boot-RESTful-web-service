package com.example.springbootrestfulwebservice.services;

import com.example.springbootrestfulwebservice.models.Cart;
import com.example.springbootrestfulwebservice.models.Item;
import com.example.springbootrestfulwebservice.models.exceptions.CartNotFoundException;
import com.example.springbootrestfulwebservice.models.exceptions.ItemAlreadyAssignedException;
import com.example.springbootrestfulwebservice.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CartServiceImp implements CartService{

    private final CartRepository cartRepository;
    private final ItemService itemService;


    @Override
    public Cart addCart(final Cart cart){
        return this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCarts(){
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getCartById(final Long id){
        return this.cartRepository.findById(id).orElseThrow(() -> new CartNotFoundException(id));
    }

    @Override
    public Cart getCartByName(final String name){
        return this.cartRepository.findByName(name).orElseThrow(CartNotFoundException::new);
    }

    @Override
    public Cart updateCartById(final Long id, final Cart givenCart){
        final Cart cart = getCartById(id);
        cart.setName(givenCart.getName());
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart updateCartByName(final String name , final Cart givenCart){
        final Cart cart = getCartByName(name);
        cart.setName(givenCart.getName());
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart deleteCartById(final Long id){
        final Cart cart = getCartById(id);
        this.cartRepository.deleteById(id);
        return cart;
    }

    @Override
    public Cart deleteByName(final String name){
        final Cart cart = getCartByName(name);
        this.cartRepository.deleteByName(name);
        return cart;
    }

    @Override
    public Cart addItemToCart(final Long cartId , final Long itemId){
        final Cart cart = getCartById(cartId);
        final Item item = this.itemService.getItemById(itemId);
        if(Objects.nonNull(item.getCart())) throw new ItemAlreadyAssignedException(cartId , itemId);
        cart.addItem(item);
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart deleteItemFromCart(Long cartId, Long itemId) {
        final Cart cart = getCartById(cartId);
        final Item item = this.itemService.getItemById(itemId);
        cart.removeItem(item);
        return this.cartRepository.save(cart);
    }


}
