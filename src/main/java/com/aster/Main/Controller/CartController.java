package com.aster.Main.Controller;

import com.aster.Main.DTO.CartDto;
import com.aster.Main.DTO.ToAddCart;
import com.aster.Main.Entity.Cart;
import com.aster.Main.Service.CartService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/create")
    public  ResponseEntity<?> addCart(@RequestBody CartDto request){
        Cart cart=cartService.createCart(request);
        return  new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCart(@PathVariable int id){
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addProductToCart(@RequestBody ToAddCart toAddCart){
        Cart cart = cartService.addItemToCart(toAddCart.getSku(),toAddCart.getQuantity(),toAddCart.getId());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

}
