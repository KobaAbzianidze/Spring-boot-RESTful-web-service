package com.example.springbootrestfulwebservice.controllers;

import com.example.springbootrestfulwebservice.models.Cart;
import com.example.springbootrestfulwebservice.models.dto.CartDto;
import com.example.springbootrestfulwebservice.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> addCart(@RequestBody final CartDto cartDto){
        final Cart cart = this.cartService.addCart(Cart.from(cartDto));
        return new ResponseEntity<>( CartDto.from(cart) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getCarts(){
        final List<CartDto> cartDto = this.cartService.getCarts().stream().map(CartDto::from).toList();
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable final Long id){
        final CartDto cartDto = CartDto.from(this.cartService.getCartById(id));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CartDto> getCartByName(@PathVariable("name") final String name){
        final CartDto cartDto = CartDto.from(this.cartService.getCartByName(name));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDto> updateCartById(@PathVariable("id") final Long id,
                                                  @RequestBody final CartDto dto){
        final CartDto cartDto = CartDto.from(this.cartService.updateCartById(id , Cart.from(dto)));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<CartDto> updateCartById(@PathVariable("name") final String name,
                                                  @RequestBody final CartDto dto){
        final CartDto cartDto = CartDto.from(this.cartService.updateCartByName(name , Cart.from(dto)));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartDto> deleteCartById(@PathVariable final Long id){
        final CartDto cartDto = CartDto.from(this.cartService.deleteCartById(id));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<CartDto> deleteCartById(@PathVariable("name") final String name){
        final CartDto cartDto = CartDto.from(this.cartService.deleteByName(name));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @PostMapping("/{cart_id}/items/{item_id}/add")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable("cart_id") final Long cartId,
                                                 @PathVariable("item_id") final Long itemId){
        final CartDto cartDto = CartDto.from(this.cartService.addItemToCart(cartId , itemId));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

    @DeleteMapping("/{cart_id}/items/{item_id}/delete")
    public ResponseEntity<CartDto> deleteItemFromCart(@PathVariable("cart_id") final Long cartId,
                                                      @PathVariable("item_id") final Long itemId){
        final CartDto cartDto = CartDto.from(this.cartService.deleteItemFromCart(cartId , itemId));
        return new ResponseEntity<>(cartDto , HttpStatus.OK);
    }

}
