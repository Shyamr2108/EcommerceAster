package com.aster.Main.Service;

import com.aster.Main.DTO.CartDto;
import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.Product;
import com.aster.Main.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart createCart(CartDto cartDto);
    Cart addItemToCart(int sku, int quantity,int id);

    Cart updateItemInCart(Product product, int quantity,Cart cart);

    Cart getCart(int id);

//    Cart deleteItemFromCart(Product product,User user);
}
