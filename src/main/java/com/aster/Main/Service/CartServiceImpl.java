package com.aster.Main.Service;

import com.aster.Main.Entity.Cart;
import com.aster.Main.Entity.CartEntry;
import com.aster.Main.Entity.Product;
import com.aster.Main.Entity.User;
import com.aster.Main.Repository.CartEntryRepository;
import com.aster.Main.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;


    @Override
    public Cart addItemToCart(Product product, int quantity, User user) {
        Cart cart=user.getCart();
        if(cart==null){
            cart=new Cart();
        }
        Set<CartEntry> cartitems = cart.getCartEntrySet();
        CartEntry cartEntry = findCartItem(cartitems,product.getSku())  ;
        if (cartitems == null) {
            cartitems = new HashSet<>();
            if (cartEntry == null) {
                cartEntry = new CartEntry();
                cartEntry.setProduct(product);
                cartEntry.setTotalPrice(quantity * product.getPrice());
                cartEntry.setQuantity(quantity);
                cartEntry.setCart(cart);
                cartitems.add(cartEntry);
                cartEntryRepository.save(cartEntry);
            }
        }
        else {
            if (cartEntry == null) {
                cartEntry = new CartEntry();
                cartEntry.setProduct(product);
                cartEntry.setTotalPrice(quantity * product.getPrice());
                cartEntry.setQuantity(quantity);
                cartEntry.setCart(cart);
                cartitems.add(cartEntry);
                cartEntryRepository.save(cartEntry);
            }
            else {
                cartEntry.setQuantity(cartEntry.getQuantity() + quantity);
                cartEntry.setTotalPrice(cartEntry.getTotalPrice() + ( quantity * product.getPrice()));
                cartEntryRepository.save(cartEntry);
            }


        }
        cart.setCartEntrySet(cartitems);
        double totalPrice = totalPrice(cart.getCartEntrySet());

        cart.setGrandTotal(totalPrice);
        cart.setUser(user);

        return cartRepository.save(cart);
    }

    @Override
    public Cart updateItemInCart(Product product, int quantity,User user) {
        Cart cart = user.getCart();

        Set<CartEntry> cartItems = cart.getCartEntrySet();

        CartEntry cartEntry = findCartItem(cartItems, product.getSku());

        cartEntry.setQuantity(quantity);
        cartEntry.setTotalPrice(quantity * product.getPrice());

        cartEntryRepository.save(cartEntry);

        double totalPrice = totalPrice(cartItems);
        cart.setGrandTotal(totalPrice);

        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteItemFromCart(Product product,User user) {
        Cart cart = user.getCart();

        Set<CartEntry> cartItems = cart.getCartEntrySet();

        CartEntry cartEntry = findCartItem(cartItems, product.getSku());

        cartItems.remove(cartEntry);

        cartEntryRepository.delete(cartEntry);

        double totalPrice = totalPrice(cartItems);

        cart.setCartEntrySet(cartItems);
        cart.setGrandTotal(totalPrice);

        return cartRepository.save(cart);
    }

    private CartEntry findCartItem(Set<CartEntry> cartEntrySet, int productId) {
        if (cartEntrySet == null) {
            return null;
        }
        CartEntry cartEntry = null;

        for (CartEntry item : cartEntrySet) {
            if (item.getProduct().getSku() == productId) {
                cartEntry = item;
            }
        }
        return cartEntry;
    }
    private double totalPrice(Set<CartEntry> cartItems){
        double totalPrice = 0.0;

        for(CartEntry item : cartItems){
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }
}
