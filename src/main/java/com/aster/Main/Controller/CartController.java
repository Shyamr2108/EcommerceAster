package com.aster.Main.Controller;

import com.aster.Main.DTO.ToAddCart;
import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.User;
import com.aster.Main.Service.CartService;
import com.aster.Main.Service.ProductService;
import com.aster.Main.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;

    @GetMapping("/cart/{id}")
    public ResponseEntity<?> getCart(@PathVariable int id){
        User user = userService.getOne(id);
        Cart cart = user.getCart();
        if(cart == null){
            System.out.println("NO item in your cart");
        }
        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<?> createProductForUser(@RequestBody ToAddCart toAddCart){
        Cart cart = cartService.addItemToCart(toAddCart.getSku(),toAddCart.getQuantity(),toAddCart.getId());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

}
