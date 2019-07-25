package main;

import java.math.BigDecimal;
import java.util.Objects;

public class ShopUser extends OnlineUser{
    /*In production environment I would put the currency
    * in an enum and make it dynamically change, according
    * to the user's preference, but since that's not the
    * purpose of the task, I just hardcoded "BGN"*/
    private static final String CHECKOUT_MESSAGE_TEMPLATE
            = "Thank you for shopping here!\nYour bill has a total of %s BGN";
    private ShoppingCart cart;

    public ShopUser(String username, String password, ShoppingCart cart) {
        super(username, password);
        this.cart = cart;
    }

    public void addToCart(ShopItem item,
                          Integer quantity) {
        cart.addItem(item, quantity);
    }

    public boolean removeFromCart(ShopItem item,
                                  Integer quantity) {
        return cart.removeItem(item, quantity);
    }

    public String checkout() {
        String message = String.format(
                CHECKOUT_MESSAGE_TEMPLATE,
                cart.getTotalPrice());
        cart.clearCart();
        return message;
    }

    public BigDecimal getCartContentPrice() {
        return cart.getTotalPrice();
    }
    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public String reviewCart() {
        return cart.reviewContent();
    }
}
