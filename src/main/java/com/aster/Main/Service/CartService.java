package com.aster.Main.Service;

import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.Product;
import com.aster.Main.Entity.User;

public interface CartService {
    Cart addItemToCart(Product product, int quantity, User user);

    Cart updateItemInCart(Product product, int quantity,User user);

    Cart deleteItemFromCart(Product product,User user);
}
