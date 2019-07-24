package main;

import java.math.BigDecimal;
import java.util.Objects;

public class ShopUser extends OnlineUser{
    private ShoppingCart cart;

    public ShopUser(String username, String password, ShoppingCart cart) {
        super(username, password);
        this.cart = cart;
    }

    public void addToCart(ShopItem item) {
        cart.addItem(item);
    }

    public boolean removeFromCart(ShopItem item) {
        return cart.removeItem(item);
    }

    public BigDecimal checkout() {
        BigDecimal totalPrice = cart.getTotalPrice();
        cart.clearCart();
        return totalPrice;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
