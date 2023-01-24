package com.aster.Main.Service;

import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.Product;
import com.aster.Main.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart addItemToCart(int sku,int quantity, int id);

    Cart updateItemInCart(Product product, int quantity,User user);

    Cart deleteItemFromCart(Product product,User user);
}
